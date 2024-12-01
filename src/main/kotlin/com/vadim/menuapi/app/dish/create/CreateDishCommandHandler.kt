package com.vadim.menuapi.app.dish.create

import com.vadim.menuapi.cqrs.annotation.Handler
import com.vadim.menuapi.cqrs.command.CommandHandler
import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.create.CreateDishCommand

@Handler
class CreateDishCommandHandler(
    private val createDishUseCase: CreateDishUseCase
): CommandHandler<CreateDishCommand, Dish> {
    override fun handle(command: CreateDishCommand): Dish =
        createDishUseCase.execute(command.newDishParams)
}