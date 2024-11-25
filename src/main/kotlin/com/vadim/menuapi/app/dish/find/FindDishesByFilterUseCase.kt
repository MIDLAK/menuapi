package com.vadim.menuapi.app.dish.find

import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.DishRepository
import com.vadim.menuapi.domain.dish.find.FindDishesFilter
import com.vadim.menuapi.domain.dish.notify.DishNotifier
import org.springframework.stereotype.Component


@Component
class FindDishesByFilterUseCase(
    private val dishesRepository: DishRepository,
    private val dishNotifier: DishNotifier
) {
    fun execute(findDishesFilter: FindDishesFilter): Collection<Dish> =
        dishesRepository.find(findDishesFilter.dishIds)
            .filter { it.isActive }
}