package com.javabom.api.domain.mining.dto

import com.javabom.core.domain.member.Mining

data class MiningDto(
    val id: Long,
    val amount: Long,
    val duration: Long,
    val memberNumber: String,
) {
    constructor(mining: Mining) : this(
        id = mining.id!!,
        amount = mining.amount,
        duration = mining.duration,
        memberNumber = mining.memberNumber
    )
}
