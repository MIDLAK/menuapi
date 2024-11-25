package com.vadim.menuapi.app.dish.delete

import com.vadim.menuapi.cqrs.annotation.Handler
import com.vadim.menuapi.cqrs.command.CommandHandler
import com.vadim.menuapi.domain.dish.delete.DeleteDishCommand

@Handler
class DeleteDishCommandHandler(
    private val inactivateDishUseCase: InactivateDishUseCase
): CommandHandler<DeleteDishCommand, Unit> {
    override fun handle(command: DeleteDishCommand) {
        inactivateDishUseCase.execute(dishId = command.dishId)
    }
}