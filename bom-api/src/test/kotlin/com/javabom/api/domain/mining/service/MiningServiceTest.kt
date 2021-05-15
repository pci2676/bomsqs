package com.javabom.api.domain.mining.service

import com.javabom.api.test.ApiTest
import com.javabom.application.domain.mining.dto.MiningCreator
import com.javabom.application.domain.mining.repository.MiningRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@ApiTest
internal class MiningServiceTest(
    @Autowired val miningService: MiningService,
    @Autowired val miningRepository: MiningRepository,
) {
    @AfterEach
    internal fun tearDown() {
        miningRepository.deleteAllInBatch()
    }

    @Test
    fun `createMining - 마이닝 생성하기`() {
        //given
        val creator = MiningCreator(
            amount = 100,
            duration = 5,
            memberNumber = "M00000000"
        )

        //when
        val dto = miningService.create(creator)

        //then
        val mining = miningRepository.findById(dto.id)
        assertThat(mining).isNotNull
    }
}
