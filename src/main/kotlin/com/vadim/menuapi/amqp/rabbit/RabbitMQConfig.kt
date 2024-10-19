package com.vadim.menuapi.amqp.rabbit

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Конфигурация RabbitMQ
 */
@Configuration
class RabbitMQConfig {

    /**
     * Очередь по умолчанию
     */
    @Bean
    fun menuQueue(): Queue =
        Queue("menuqueue", true)

    /**
     * Шаблон взаимодействия с RabbitMQ
     */
    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = Jackson2JsonMessageConverter()
        return rabbitTemplate
    }
}