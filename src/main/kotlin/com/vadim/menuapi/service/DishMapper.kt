package com.vadim.menuapi.service

import com.vadim.menuapi.dto.DishDto
import com.vadim.menuapi.entity.DishEntity

object DishMapper {

    fun DishEntity.toDto(): DishDto =
        DishDto (id = this.dishId, name = this.name)
}