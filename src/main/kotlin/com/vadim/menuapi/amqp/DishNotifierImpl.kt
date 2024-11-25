package com.vadim.menuapi.amqp

import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.notify.DishNotifier
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class DishNotifierImpl(
    private val rabbitTemplate: RabbitTemplate
): DishNotifier {
    override fun notifyAboutDishes(queueName: String, dishes: Collection<Dish>) =
        rabbitTemplate.convertAndSend(queueName, dishes)
}