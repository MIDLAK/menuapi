package com.vadim.menuapi.amqp

import com.vadim.menuapi.cqrs.command.CommandBus
import com.vadim.menuapi.cqrs.query.QueryBus
import com.vadim.menuapi.domain.ingredient.Ingredient
import com.vadim.menuapi.domain.ingredient.find.FindAllIngredientsQuery
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class IngredientController(
    private val queryBus: QueryBus,
    private val commandBus: CommandBus
) {

    @RabbitListener(queues = ["menu_ingredients"])
    fun listenFind(): Collection<Ingredient> =
        queryBus.handle(FindAllIngredientsQuery())
}