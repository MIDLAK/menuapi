package com.vadim.menuapi.domain.dish.delete

import com.vadim.menuapi.cqrs.command.Command
import java.util.UUID

data class DeleteDishCommand(
    val dishId: UUID
): Command<Unit>