package com.example.letsgetfit.data.database.converters

import androidx.room.TypeConverter
import com.example.letsgetfit.domain.pojo.TrainingItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class TrainingConverter {
    @TypeConverter
    fun toListTrainingFromJson(training:String):List<TrainingItem>{
        if(training == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<TrainingItem>>(){}.type
        return Gson().fromJson(training,type)
    }
    @TypeConverter
    fun fromJsonToListTraining(training:List<TrainingItem>):String{
        return Gson().toJson(training)
    }
}