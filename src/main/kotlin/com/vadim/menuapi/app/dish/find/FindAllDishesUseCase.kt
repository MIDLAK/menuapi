package com.vadim.menuapi.app.dish.find

import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.DishRepository
import com.vadim.menuapi.domain.dish.notify.DishNotifier
import org.springframework.stereotype.Component

/**
 * Поиск всех доступных блюд
 */
@Component
class FindAllDishesUseCase(
    private val dishRepository: DishRepository,
    private val dishNotifier: DishNotifier
) {

    /**
     * Поиск всех доступных блюд
     */
    fun execute(): Collection<Dish> =
        dishRepository.findAllDishes()
            .filter { it.isActive }
            .also {
                /* отправка в специальную очередь для демонстрации работы */
                dishNotifier.notifyAboutDishes(queueName = "menu_dishes", dishes = it)
            }
}