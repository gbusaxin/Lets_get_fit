package com.example.letsgetfit.data.mappers

import com.example.letsgetfit.data.database.models.MotivationInfoDbModel
import com.example.letsgetfit.data.network.models.MotivationInfoDto
import com.example.letsgetfit.domain.pojo.MotivationInfo

class MotivationMapper {
    fun mapDbModelToEntity(dbModel: MotivationInfoDbModel) = MotivationInfo(
        author = dbModel.author,
        image = dbModel.image,
        message = dbModel.message
    )
    fun mapDtoToDbModel(dto: MotivationInfoDto) = MotivationInfoDbModel(
        author = dto.author?:"c",
        image = dto.image?:"",
        message = dto.message?:"c"
    )
}