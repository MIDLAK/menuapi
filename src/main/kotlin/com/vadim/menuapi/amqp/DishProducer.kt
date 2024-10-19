package com.vadim.menuapi.amqp

import com.vadim.menuapi.dto.DishDto

/**
 * Отправитель блюд
 */
interface DishProducer {

    /**
     * Отправить все блюда в очередь
     */
    fun sendDishes(dishes: Collection<DishDto>)
}