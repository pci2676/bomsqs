package com.javabom.api.domain.mining.service

import com.javabom.api.domain.mining.dto.MiningDto
import com.javabom.application.domain.mining.dto.MiningCreator
import com.javabom.application.domain.mining.repository.MiningRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MiningService(
    val miningRepository: MiningRepository,
) {
    fun create(creator: MiningCreator): MiningDto {
        var mining = creator.toMining()

        mining = miningRepository.save(mining)

        return MiningDto(mining)
    }
}
