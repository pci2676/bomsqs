package com.javabom.core.domain.member

import com.javabom.core.domain.member.value.MiningStatus
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@Table(
    name = "mining",
    uniqueConstraints = [
        UniqueConstraint(name = "uk_mining", columnNames = ["member_number"])
    ]
)
class Mining(
    @Column(name = "amount", columnDefinition = "comment '1회 채굴량'")
    val amount: Long,
    @Column(name = "amount", columnDefinition = "comment '채굴 주기'")
    val duration: Long,
    @Column(name = "amount", columnDefinition = "comment '회원 번호'")
    val memberNumber: String,
    @Enumerated(EnumType.STRING)
    @Column(name = "mining_status", columnDefinition = "comment '활성화 상태'")
    var miningStatus: MiningStatus = MiningStatus.ENABLE,
) {
    fun disable() {
        this.miningStatus = this.miningStatus.disable()
    }
}
