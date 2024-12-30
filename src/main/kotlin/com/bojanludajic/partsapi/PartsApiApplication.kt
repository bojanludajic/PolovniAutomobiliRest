package com.bojanludajic.partsapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan("model")
class PartsApiApplication

fun main(args: Array<String>) {
    runApplication<PartsApiApplication>(*args)
}
