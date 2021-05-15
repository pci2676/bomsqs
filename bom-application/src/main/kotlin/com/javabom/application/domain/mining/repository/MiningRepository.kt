package com.javabom.application.domain.mining.repository

import com.javabom.core.domain.member.Mining
import com.javabom.core.domain.member.QMining.mining
import com.javabom.core.domain.member.value.MiningStatus
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.jpa.repository.JpaRepository

interface MiningRepository : JpaRepository<Mining, Long>, MiningQueryRepository

interface MiningQueryRepository {
    fun findAllByMemberNumber(memberNumber: String): List<Mining>
}

class MiningQueryRepositoryImpl(
    private val query: JPAQueryFactory,
) : MiningQueryRepository {
    override fun findAllByMemberNumber(memberNumber: String): List<Mining> {
        return query.selectFrom(mining)
            .where(mining.miningStatus.eq(MiningStatus.ENABLE)
                .and(mining.memberNumber.eq(memberNumber)))
            .fetch()
    }
}
