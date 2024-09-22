package com.vadim.menuapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MenuApplication

fun main(args: Array<String>) {
	runApplication<MenuApplication>(*args)
}
