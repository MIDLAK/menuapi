package com.vadim.menuapi.common.ingredient

import com.vadim.menuapi.common.ingredient.type.IngredientTypeMapper.toDto
import com.vadim.menuapi.domain.ingredient.Ingredient

object IngredientMapper {

    fun Ingredient.toDto(): IngredientDto =
        IngredientDto(
            name = this.name,
            price = this.price,
            type = this.type.toDto()
        )

    fun Collection<Ingredient>.toDto(): Collection<IngredientDto> =
        this.map { it.toDto() }
}