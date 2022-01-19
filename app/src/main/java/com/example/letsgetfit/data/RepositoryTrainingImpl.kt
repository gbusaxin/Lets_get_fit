package com.example.letsgetfit.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.letsgetfit.data.database.room.DbRoom
import com.example.letsgetfit.data.mappers.TrainingMapper
import com.example.letsgetfit.data.network.ApiFactory
import com.example.letsgetfit.domain.pojo.TrainingInfo
import com.example.letsgetfit.domain.repositories.TrainingRepository

class RepositoryTrainingImpl(private val application: Application) : TrainingRepository {

    private val db = DbRoom.instance(application)
    private val retrofit = ApiFactory.apiService
    private val mapper = TrainingMapper()

    override fun getTrainingList(): LiveData<List<TrainingInfo>> {
        return Transformations.map(db.dao().getTrainingList()) {
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    override suspend fun loadTrainingList() {
        try {
            val dto = retrofit.loadTrainingList()
            val dbModel = dto.map { mapper.mapDtoToDbModel(it) }
            db.dao().insertTrainingList(dbModel)
        } catch (e: Exception) {
        }
    }
}