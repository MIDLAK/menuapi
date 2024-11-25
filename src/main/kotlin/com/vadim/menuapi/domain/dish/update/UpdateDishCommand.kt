package com.vadim.menuapi.domain.dish.update

import com.vadim.menuapi.cqrs.command.Command
import com.vadim.menuapi.domain.dish.Dish

data class UpdateDishCommand(
    val dishUpdate: DishUpdate
): Command<Dish>