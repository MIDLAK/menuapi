package com.vadim.menuapi.domain

import com.vadim.menuapi.web.DishDto

/**
 * Отправитель блюд
 */
interface DishProducer {

    /**
     * Отправить все блюда в очередь
     */
    fun sendDishes(dishes: Collection<DishDto>)
}