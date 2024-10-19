package com.vadim.menuapi.service

import com.vadim.menuapi.dto.DishDto
import com.vadim.menuapi.amqp.DishProducer
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class DishProducerImpl(
    private val rabbitTemplate: RabbitTemplate
): DishProducer {
    override fun sendDishes(dishes: Collection<DishDto>) =
        rabbitTemplate.convertAndSend("menuqueue", dishes)
}