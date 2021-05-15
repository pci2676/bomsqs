package com.javabom.api.config

import com.javabom.application.config.BomApplicationConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(BomApplicationConfig::class)
@ComponentScan(value = [
    "com.javabom.api.domain"
])
@Configuration
class BomApiConfig
