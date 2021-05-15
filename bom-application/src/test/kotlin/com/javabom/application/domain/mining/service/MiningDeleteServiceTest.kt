package com.javabom.application.domain.mining.service

import com.javabom.application.config.ApplicationTest
import com.javabom.application.domain.mining.repository.MiningRepository
import com.javabom.core.domain.member.Mining
import com.javabom.core.domain.member.value.MiningStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@ApplicationTest
internal class MiningDeleteServiceTest(
    @Autowired val miningDeleteService: MiningDeleteService,
    @Autowired val miningRepository: MiningRepository,
) {

    @AfterEach
    internal fun tearDown() {
        miningRepository.deleteAllInBatch()
    }

    @Test
    fun `deleteMining - 전부 비활성화 하기`() {
        //given
        val m1 = miningRepository.save(Mining(
            amount = 1,
            duration = 2,
            memberNumber = "M00000001")
        )
        val m2 = miningRepository.save(Mining(
            amount = 2,
            duration = 3,
            memberNumber = "M00000001")
        )

        //when
        miningDeleteService.deleteAll("M00000001")

        //then
        val after1 = miningRepository.findById(m1.id!!).orElseThrow()
        val after2 = miningRepository.findById(m2.id!!).orElseThrow()
        assertThat(listOf(after1, after2).map { it.miningStatus }).containsOnly(MiningStatus.DISABLE)
    }
}
