package com.vadim.menuapi.amqp

/**
 * Потребитель блюд
 */
interface DishConsumer {

    /**
     * Печать всех поступающих из очереди блюд
     */
    fun listenAndPrint(dish: String)
}