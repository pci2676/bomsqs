package com.javabom.worker.main

import com.javabom.worker.config.BomWorkerConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(BomWorkerConfig::class)
@SpringBootApplication
class BomWorkerApplication

fun main(vararg args: String) {
    runApplication<BomWorkerApplication>(*args)
}
