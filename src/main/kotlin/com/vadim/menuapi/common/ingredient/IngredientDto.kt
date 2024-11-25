package com.vadim.menuapi.common.ingredient

import com.vadim.menuapi.common.ingredient.type.IngredientTypeDto

data class IngredientDto(
    val name: String,
    val price: Double,
    val type: IngredientTypeDto
)