package com.vadim.menuapi.domain

/**
 * Потребитель блюд
 */
interface DishConsumer {

    /**
     * Печать всех поступающих из очереди блюд
     */
    fun listenAndPrint(dish: String)
}