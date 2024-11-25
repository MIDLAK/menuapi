package com.vadim.menuapi.common.dish.update

import java.util.*


data class UpdateDishDto(
    val dishId: UUID,
    val name: String,
    val price: Double,
    val newIngredientIds: Collection<UUID>,
    val deletedIngredientIds: Collection<UUID>
)