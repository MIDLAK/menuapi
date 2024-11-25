package com.vadim.menuapi.app.dish.create

import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.DishRepository
import com.vadim.menuapi.domain.dish.create.NewDishParams
import org.springframework.stereotype.Component

@Component
class CreateDishUseCase(
    private val dishRepository: DishRepository
) {
    fun execute(newDishParams: NewDishParams): Dish =
        dishRepository.save(newDishParams)
}