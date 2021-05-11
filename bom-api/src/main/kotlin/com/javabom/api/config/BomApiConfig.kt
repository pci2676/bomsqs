package com.javabom.api.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ComponentScan(value = [
    "com.javabom.api.domain"
])
@Configuration
class BomApiConfig
