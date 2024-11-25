package com.vadim.menuapi.app.dish.create

import com.vadim.menuapi.cqrs.annotation.Handler
import com.vadim.menuapi.cqrs.command.CommandHandler
import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.create.CreateDishCommand
import com.vadim.menuapi.domain.dish.notify.DishNotifier

@Handler
class CreateDishCommandHandler(
    private val createDishUseCase: CreateDishUseCase,
    private val dishNotifier: DishNotifier
): CommandHandler<CreateDishCommand, Dish> {
    override fun handle(command: CreateDishCommand): Dish =
        createDishUseCase.execute(command.newDishParams)
}