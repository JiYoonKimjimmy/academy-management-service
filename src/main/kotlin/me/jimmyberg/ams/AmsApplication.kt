package me.jimmyberg.ams

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AmsApplication

fun main(args: Array<String>) {
    runApplication<AmsApplication>(*args)
}
