package com.vadim.menuapi.common.dish

import com.vadim.menuapi.common.ingredient.IngredientMapper.toDto
import com.vadim.menuapi.domain.dish.Dish

object DishMapper {

    fun Dish.toDto(): DishDto =
        DishDto(
            id = this.id,
            name = this.name,
            price = this.price,
            ingredients = this.ingredients.toDto()
        )

    fun Collection<Dish>.toDto(): Collection<DishDto> =
        this.map { it.toDto() }
}