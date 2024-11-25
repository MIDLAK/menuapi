package com.vadim.menuapi.app.dish.update

import com.vadim.menuapi.cqrs.annotation.Handler
import com.vadim.menuapi.cqrs.command.CommandHandler
import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.update.UpdateDishCommand

@Handler
class UpdateDishCommandHandler(
    private val updateDishUseCase: UpdateDishUseCase
): CommandHandler<UpdateDishCommand, Dish> {
    override fun handle(command: UpdateDishCommand): Dish =
        updateDishUseCase.execute(command.dishUpdate)
}