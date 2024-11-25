package com.vadim.menuapi.domain.dish.notify

import com.vadim.menuapi.domain.dish.Dish

/**
 * Оповещение о блюдах
 */
interface DishNotifier {

    /**
     * Оповещение в очередь о блюдах
     */
    fun notifyAboutDishes(queueName: String, dishes: Collection<Dish>)
}