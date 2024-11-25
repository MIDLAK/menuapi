package com.vadim.menuapi.domain.dish.create

import com.vadim.menuapi.cqrs.command.Command
import com.vadim.menuapi.domain.dish.Dish

data class CreateDishCommand(
    val newDishParams: NewDishParams
): Command<Dish>