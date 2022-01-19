package com.example.letsgetfit.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.letsgetfit.data.database.room.DbRoom
import com.example.letsgetfit.data.mappers.MotivationMapper
import com.example.letsgetfit.data.network.ApiFactory
import com.example.letsgetfit.domain.pojo.MotivationInfo
import com.example.letsgetfit.domain.repositories.MotivationRepository

class RepositoryMotivationImpl(application: Application) : MotivationRepository {

    private val db = DbRoom.instance(application).dao()
    private val retrofit = ApiFactory.apiService
    private val mapper = MotivationMapper()

    override fun getMotivationList(): LiveData<List<MotivationInfo>> {
        return Transformations.map(db.getMotivationList()) {
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    override suspend fun loadMotivationList() {
        try {
            val dto = retrofit.loadMotivationList()
            val dbModel = dto.map { mapper.mapDtoToDbModel(it) }
            db.insertMotivationList(dbModel)
        } catch (e: Exception) {
        }
    }
}