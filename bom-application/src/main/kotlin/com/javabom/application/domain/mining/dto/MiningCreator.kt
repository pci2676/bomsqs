package com.javabom.application.domain.mining.dto

import com.javabom.core.domain.member.Mining

data class MiningCreator(
    val amount: Long,
    val duration: Long,
    val memberNumber: String,
) {
    fun toMining(): Mining {
        return Mining(
            amount = amount,
            duration = duration,
            memberNumber = memberNumber
        )
    }
}
