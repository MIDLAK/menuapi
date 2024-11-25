package com.vadim.menuapi.common.ingredient.type

import com.vadim.menuapi.domain.ingredient.type.IngredientType

object IngredientTypeMapper {

    fun IngredientType.toDto(): IngredientTypeDto =
        IngredientTypeDto(
            id = this.id,
            name = this.name
        )
}