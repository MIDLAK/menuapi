package com.vadim.menuapi.domain.dish.update

import java.util.*

data class DishUpdate(
    val dishId: UUID,
    val newIngredientIds: Collection<UUID>? = null,
    val inactivatedIngredientIds: Collection<UUID>? = null,
    val price: Double? = null
) {
    init {
        isNotNullUpdate()
    }

    private fun isNotNullUpdate() =
        newIngredientIds ?: inactivatedIngredientIds ?: price
            ?: throw RuntimeException("Обновление блюда не может быть пустым")
}
