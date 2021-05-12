package com.javabom.core.domain.member.value

enum class MiningStatus {
    ENABLE,
    DISABLE
    ;

    fun disable(): MiningStatus {
        if (this == ENABLE) {
            return DISABLE
        }
        throw IllegalArgumentException("활성화 상태가 아닙니다.")
    }
}
