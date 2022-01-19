package com.example.letsgetfit.data.mappers

import com.example.letsgetfit.data.database.models.TrainingInfoDbModel
import com.example.letsgetfit.data.network.models.TrainingInfoDto
import com.example.letsgetfit.domain.pojo.TrainingInfo
import java.util.*

class TrainingMapper {
    fun mapDbModelToEntity(dbModel: TrainingInfoDbModel) = TrainingInfo(
        trainer = dbModel.trainer,
        imageTrainer = dbModel.imageTrainer,
        aboutTrainer = dbModel.aboutTrainer,
        training = dbModel.training
    )

    fun mapDtoToDbModel(dto: TrainingInfoDto) = TrainingInfoDbModel(
        trainer = dto.trainer ?: "",
        imageTrainer = dto.imageTrainer ?: "",
        aboutTrainer = dto.aboutTrainer ?: "",
        training = dto.training ?: Collections.emptyList()
    )
}