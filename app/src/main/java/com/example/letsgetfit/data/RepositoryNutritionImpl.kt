package com.example.letsgetfit.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.letsgetfit.data.database.room.DbRoom
import com.example.letsgetfit.data.mappers.NutritionMapper
import com.example.letsgetfit.data.network.ApiFactory
import com.example.letsgetfit.domain.pojo.NutritionInfo
import com.example.letsgetfit.domain.repositories.NutritionRepository
import java.lang.Exception

class RepositoryNutritionImpl(private val application: Application):NutritionRepository {

    private val db = DbRoom.instance(application).dao()
    private val retrofit = ApiFactory.apiService
    private val mapper = NutritionMapper()

    override fun getNutritionList(): LiveData<List<NutritionInfo>> {
        return Transformations.map(db.getNutritionList()){
            it.map { mapper.mapDbModelToEntity(it) }
        }
    }

    override suspend fun loadNutritionList() {
        try {
            val dto = retrofit.loadNutritionList()
            val dbModel = dto.map { mapper.mapDtoToDbModel(it) }
            db.insertNutritionList(dbModel)
        }catch (e:Exception){}
    }
}