package com.example.letsgetfit.data.database.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.letsgetfit.data.database.models.MotivationInfoDbModel
import com.example.letsgetfit.data.database.models.NutritionInfoDbModel
import com.example.letsgetfit.data.database.models.TrainingInfoDbModel

@Dao
interface DbDao {
    @Query("SELECT * FROM table_training")
    fun getTrainingList():LiveData<List<TrainingInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainingList(dbModel: List<TrainingInfoDbModel>)

    @Query("SELECT * FROM table_nutrition")
    fun getNutritionList():LiveData<List<NutritionInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNutritionList(dbModel: List<NutritionInfoDbModel>)

    @Query("SELECT * FROM table_motivation")
    fun getMotivationList():LiveData<List<MotivationInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMotivationList(dbModel: List<MotivationInfoDbModel>)
}