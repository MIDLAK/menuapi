package com.vadim.menuapi.web

import com.vadim.menuapi.cqrs.query.QueryBus
import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.find.FindAllDishesQuery
import com.vadim.menuapi.common.dish.DishMapper.toDto
import com.vadim.menuapi.common.dish.DishDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/menu")
class MenuController(
    private val queryBus: QueryBus
) {
    @GetMapping
    fun getMenu(): Collection<DishDto> {
        val dishes: Collection<Dish> = queryBus.handle(FindAllDishesQuery())
        return dishes.toDto()
    }

    @GetMapping("/test")
    fun test(): String = "ok"
}