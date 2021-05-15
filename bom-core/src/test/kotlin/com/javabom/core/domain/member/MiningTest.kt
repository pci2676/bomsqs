package com.javabom.core.domain.member

import com.javabom.core.domain.member.value.MiningStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MiningTest {
    @Test
    fun `disable - 비 활성화`() {
        //given
        val mining = Mining(amount = 0, duration = 0, memberNumber = "")

        //when
        mining.disable()

        //then
        assertThat(mining.miningStatus).isEqualTo(MiningStatus.DISABLE)
    }
}
