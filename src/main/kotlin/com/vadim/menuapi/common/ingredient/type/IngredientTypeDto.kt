package com.vadim.menuapi.common.ingredient.type

import com.vadim.menuapi.domain.ingredient.type.IngredientTypeEnum

data class IngredientTypeDto(
    val id: IngredientTypeEnum,
    val name: String
)