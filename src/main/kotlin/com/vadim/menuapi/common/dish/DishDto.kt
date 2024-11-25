package com.vadim.menuapi.common.dish

import com.vadim.menuapi.common.ingredient.IngredientDto
import java.util.UUID

data class DishDto(
    val id: UUID,
    val name: String,
    val price: Double,
    val ingredients: Collection<IngredientDto>
)