package com.example.letsgetfit.data.mappers

import com.example.letsgetfit.data.database.models.NutritionInfoDbModel
import com.example.letsgetfit.data.network.models.NutritionInfoDto
import com.example.letsgetfit.domain.pojo.NutritionInfo

class NutritionMapper {
    fun mapDbModelToEntity(dbModel: NutritionInfoDbModel) = NutritionInfo(
        title = dbModel.title,
        shortDesc = dbModel.shortDesc,
        backgroundImage = dbModel.backgroundImage,
        date = dbModel.date,
        description = dbModel.description
    )
    fun mapDtoToDbModel(dto: NutritionInfoDto) = NutritionInfoDbModel(
        title = dto.title?:"",
        shortDesc = dto.shortDesc?:"",
        backgroundImage = dto.backgroundImage?:"",
        date = dto.date?:"",
        description = dto.description?:""
    )
}