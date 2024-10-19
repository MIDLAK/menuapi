package com.vadim.menuapi.service

import com.vadim.menuapi.amqp.DishConsumer
import com.vadim.menuapi.dto.DishDto
import netscape.javascript.JSObject
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
    @RabbitListener(queues = ["menuqueue"])
    override fun listenAndPrint(dish: String) = println(dish)
}