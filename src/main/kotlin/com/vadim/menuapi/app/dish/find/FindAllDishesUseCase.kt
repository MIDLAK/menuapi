package com.vadim.menuapi.app.dish.find

import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.DishRepository
import org.springframework.stereotype.Component

/**
 * Поиск всех доступных блюд
 */
@Component
class FindAllDishesUseCase(
    private val dishRepository: DishRepository
) {

    /**
     * Поиск всех доступных блюд
     */
    fun execute(): Collection<Dish> =
        dishRepository.findAllDishes()
            .filter { it.isActive }
}