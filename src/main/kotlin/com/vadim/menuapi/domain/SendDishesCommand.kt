package com.vadim.menuapi.domain

import com.vadim.menuapi.cqrs.command.Command

data class SendDishesCommand(
    val dishes: Collection<Dish>
): Command<Unit>
