package com.vadim.menuapi.controller

import com.vadim.menuapi.dto.DishDto
import com.vadim.menuapi.service.DishService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/menu")
class MenuController(
    private val dishService: DishService
) {
    @GetMapping
    fun getAll(): Collection<DishDto> =
        dishService.getAll()
}