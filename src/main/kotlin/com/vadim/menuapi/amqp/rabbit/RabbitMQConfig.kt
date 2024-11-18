package com.vadim.menuapi.amqp.rabbit

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitAdmin
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Конфигурация RabbitMQ для динамического создания множества очередей без маршрутизации.
 */
@Configuration
class RabbitMQConfig {

    /**
     * Префикс для имени очередей
     */
    @Value("\${rabbitmq.queue.prefix}")
    lateinit var queuePrefix: String

    /**
     * Список имен очередей
     */
    @Value("\${rabbitmq.queue.names}")
    lateinit var queueNames: List<String>

    /**
     * Создаем очереди без маршрутизации, только прямые очереди.
     */
    /**
     * Создаем очередь с помощью RabbitAdmin для их явного создания в RabbitMQ.
     */
    @Bean
    fun rabbitAdmin(connectionFactory: ConnectionFactory): RabbitAdmin {
        val rabbitAdmin = RabbitAdmin(connectionFactory)
        // Создаем очереди, если они не существуют
        queueNames.forEach {
            val queue = Queue("$queuePrefix$it", true, false, false)
            rabbitAdmin.declareQueue(queue)  // Явное создание очереди в RabbitMQ
        }
        return rabbitAdmin
    }

    /**
     * RabbitTemplate для отправки сообщений.
     */
    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = Jackson2JsonMessageConverter()
        return rabbitTemplate
    }
}
