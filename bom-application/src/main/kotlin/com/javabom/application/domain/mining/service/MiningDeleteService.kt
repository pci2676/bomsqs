package com.javabom.application.domain.mining.service

import com.javabom.application.domain.mining.repository.MiningRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MiningDeleteService(
    private val miningRepository: MiningRepository,
) {
    fun deleteAll(memberNumber: String) {
        val miningList = miningRepository.findAllByMemberNumber(memberNumber)
        miningList.forEach { it.disable() }
    }
}
