package com.vadim.menuapi.common.dish.create

import java.util.*

data class CreateDishDto(
    val name: String,
    val price: Double,
    val ingredientIds: Collection<UUID>
)