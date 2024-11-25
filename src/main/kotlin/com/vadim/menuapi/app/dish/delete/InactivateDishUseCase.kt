package com.vadim.menuapi.app.dish.delete

import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.DishRepository
import org.springframework.stereotype.Component
import java.util.UUID


@Component
class InactivateDishUseCase(
    private val dishRepository: DishRepository
) {
    fun execute(dishId: UUID) =
        execute(dish = dishRepository.find(dishId = dishId))

    fun execute(dish: Dish): Dish =
        dishRepository.save(dish.apply { this.isActive = false })
}