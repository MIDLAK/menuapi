package com.vadim.menuapi.web

import com.vadim.menuapi.domain.Dish

object DishMapper {

    fun Dish.toDto(): DishDto =
        DishDto (id = this.dishId, name = this.name)

    fun Collection<Dish>.toDto(): Collection<DishDto> =
        this.map { it.toDto() }
}