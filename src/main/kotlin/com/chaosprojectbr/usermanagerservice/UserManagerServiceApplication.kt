package com.chaosprojectbr.usermanagerservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UserManagerServiceApplication

fun main(args: Array<String>) {
	runApplication<UserManagerServiceApplication>(*args)
}
