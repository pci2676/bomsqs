package com.javabom.application.config

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest

@EnableAutoConfiguration
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@SpringBootTest(classes = [BomApplicationConfig::class])
annotation class ApplicationTest
