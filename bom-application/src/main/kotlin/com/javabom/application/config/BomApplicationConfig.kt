package com.javabom.application.config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@EntityScan(value = [
    "com.javabom.core.domain"
])
@EnableJpaRepositories(value = [
    "com.javabom.application.domain"
])
@EnableJpaAuditing
@ComponentScan(value = [
    "com.javabom.application.domain"
])
@Configuration
class BomApplicationConfig(
    @PersistenceContext
    private val entityManager: EntityManager? = null,
) {
    @Bean
    fun jpaQueryFactory(): JPAQueryFactory {
        return JPAQueryFactory(entityManager)
    }
}
