package com.javabom.api.main

import com.javabom.api.config.BomApiConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(BomApiConfig::class)
@SpringBootApplication
class BomApiApplication

fun main(vararg args: String) {
    runApplication<BomApiApplication>(*args)
}
