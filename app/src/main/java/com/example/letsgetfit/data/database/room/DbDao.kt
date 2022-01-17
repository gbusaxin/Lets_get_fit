package com.example.letsgetfit.data.database.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.letsgetfit.data.database.models.TrainingInfoDbModel

@Dao
interface DbDao {
    @Query("SELECT * FROM table_training")
    fun getTrainingList():LiveData<TrainingInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainingList(dbModel: TrainingInfoDbModel)
}