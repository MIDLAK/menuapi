package com.vadim.menuapi.amqp.rabbit

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * Конфигурация RabbitMQ для динамического создания множества очередей
 */
@Configuration
class RabbitMQConfig {
    /**
     * Ключ маршрутизации для обращения к приложению
     */
    @Bean
    fun directExchange(): DirectExchange =
        DirectExchange("vadim.menu")

    /**
     * Очередь блюд
     */
    @Bean
    fun dishQueue(): Queue = Queue("dish_request")

    /**
     * Очередь ингридиентов
     */
    @Bean
    fun ingredientQueue(): Queue = Queue("ingredient_request")

    /**
     * Привязка ключа блюд к очереди
     */
    @Bean
    fun dishBinding(
        directExchange: DirectExchange?,
    ): Binding =
        BindingBuilder.bind(dishQueue())
            .to(directExchange)
            .with("dish")

    /**
     * Привязка ключа ингридиентов к очереди
     */
    @Bean
    fun ingredientBinding(
        directExchange: DirectExchange?,
    ): Binding =
        BindingBuilder.bind(ingredientQueue())
            .to(directExchange)
            .with("ingredient")

    /**
     * Сериализация и десериализация сообщений
     */
    @Bean
    fun jackson2MessageConverter(): MessageConverter =
        Jackson2JsonMessageConverter()
}
