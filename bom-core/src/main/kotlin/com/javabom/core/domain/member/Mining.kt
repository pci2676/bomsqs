package com.javabom.core.domain.member

import com.javabom.core.domain.member.value.MiningStatus
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Index
import javax.persistence.Table

@Entity
@Table(
    name = "mining",
    indexes = [
        Index(name = "ix_mining", columnList = "member_number")
    ]
)
class Mining(
    amount: Long,
    duration: Long,
    memberNumber: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null
        protected set

    @Column(name = "amount", columnDefinition = "bigint comment '1회 채굴량'")
    val amount: Long = amount

    @Column(name = "duration", columnDefinition = "bigint comment '채굴 주기'")
    val duration: Long = duration

    @Column(name = "member_number", columnDefinition = "varchar(50) comment '회원 번호'")
    val memberNumber: String = memberNumber

    @Enumerated(EnumType.STRING)
    @Column(name = "mining_status", columnDefinition = "varchar(20) comment '활성화 상태'")
    var miningStatus: MiningStatus = MiningStatus.ENABLE
        protected set

    fun disable() {
        this.miningStatus = this.miningStatus.disable()
    }
}
