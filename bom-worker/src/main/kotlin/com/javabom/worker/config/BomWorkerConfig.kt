package com.javabom.worker.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ComponentScan(value = [
    "com.javabom.worker.domain"
])
@Configuration
class BomWorkerConfig
