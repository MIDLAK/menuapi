package com.vadim.menuapi.amqp

import com.vadim.menuapi.domain.DishConsumer
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

/**
 * Потребитель блюд
 */
@Service
class DishConsumerImpl: DishConsumer {

    /**
     * Печать всех поступающих из очереди блюд
     */
    @RabbitListener(queues = ["menu_dishes"])
    override fun listenAndPrint(dish: String) = println(dish)
}