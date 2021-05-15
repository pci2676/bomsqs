package com.javabom.api.domain.mining.facade

import com.javabom.api.domain.mining.dto.MiningCreateRequest
import com.javabom.api.domain.mining.dto.MiningDto
import com.javabom.api.domain.mining.service.MiningService
import com.javabom.application.domain.mining.service.MiningDeleteService
import org.springframework.stereotype.Component

@Component
class MiningFacade(
    private val miningService: MiningService,
    private val miningDeleteService: MiningDeleteService,
) {
    fun createMining(memberNumber: String, request: MiningCreateRequest): MiningDto {
        val creator = request.toMiningCreator(memberNumber)
        return miningService.create(creator)
    }

    fun deleteMining(memberNumber: String) {
        miningDeleteService.deleteAll(memberNumber)
    }
}
