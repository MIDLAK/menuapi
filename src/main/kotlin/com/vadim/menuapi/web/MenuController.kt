package com.vadim.menuapi.web

import com.vadim.menuapi.common.dish.find.FindDishesDto
import com.vadim.menuapi.common.ingredient.FindIngredientsDto
import com.vadim.menuapi.cqrs.query.QueryBus
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/menu")
class MenuController(
    private val rabbitTemplate: RabbitTemplate
) {
    /**
     * Запрос для теста ответа
     */
    @GetMapping
    fun getMenu() {
        println(
            rabbitTemplate.convertSendAndReceive(
                "vadim.menu",
                "dish",
                FindDishesDto(findAll = true)
            )
        )

        println(
            rabbitTemplate.convertSendAndReceive(
                "vadim.menu",
                "ingredient",
                FindIngredientsDto()
            )
        )
    }

    @GetMapping("/test")
    fun test(): String = "ok"
}