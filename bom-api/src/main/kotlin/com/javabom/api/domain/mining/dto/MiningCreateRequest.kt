package com.javabom.api.domain.mining.dto

import com.javabom.application.domain.mining.dto.MiningCreator

data class MiningCreateRequest(
    val amount: Long,
    val duration: Long,
) {
    fun toMiningCreator(memberNumber: String): MiningCreator {
        return MiningCreator(
            amount = amount,
            duration = duration,
            memberNumber = memberNumber)
    }
}
