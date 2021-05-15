package com.javabom.core.domain.member.value

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MiningStatusTest {

    @Test
    fun `disable - 활성화시 비활성화 가능`() {
        //given
        val status = MiningStatus.ENABLE

        //when
        val result = status.disable()

        //then
        assertThat(result).isEqualTo(MiningStatus.DISABLE)
    }

    @Test
    fun `disable - 비활성화시 비활성화 불가능`() {
        //given
        val status = MiningStatus.DISABLE

        //then
        assertThrows<IllegalArgumentException> {
            status.disable()
        }
    }
}
