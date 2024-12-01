package com.vadim.menuapi.amqp.ingredient

import com.vadim.menuapi.common.ingredient.FindIngredientsDto
import com.vadim.menuapi.common.ingredient.IngredientDto
import com.vadim.menuapi.common.ingredient.IngredientMapper.toDto
import com.vadim.menuapi.cqrs.query.QueryBus
import com.vadim.menuapi.domain.ingredient.find.FindAllIngredientsQuery
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Controller

@Controller
@RabbitListener(queues = ["ingredient_request"])
class IngredientController(
    private val queryBus: QueryBus
) {
    @RabbitHandler
    fun listenFind(findIngredientsDto: FindIngredientsDto): Collection<IngredientDto> =
        queryBus.handle(FindAllIngredientsQuery()).toDto()
}