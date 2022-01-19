package com.example.letsgetfit.data.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.letsgetfit.data.database.models.MotivationInfoDbModel
import com.example.letsgetfit.data.database.models.NutritionInfoDbModel
import com.example.letsgetfit.data.database.models.TrainingInfoDbModel

@Database(
    entities = [
        TrainingInfoDbModel::class,
        NutritionInfoDbModel::class,
        MotivationInfoDbModel::class
    ],
    version = 3,
    exportSchema = false
)
abstract class DbRoom : RoomDatabase() {

    companion object {

        private const val DB_NAME = "fit.db"
        private var db: DbRoom? = null
        private val LOCK = Any()

        fun instance(context: Context): DbRoom {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(context, DbRoom::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun dao(): DbDao
}