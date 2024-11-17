package com.vadim.menuapi.amqp.rabbit

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Конфигурация RabbitMQ
 */
@Configuration
class RabbitMQConfig {

    /**
     * Название очереди поиска блюд
     */
    @Value("\${rabbitmq.queue.menu.find}")
    lateinit var menuFindQueue: String

    /**
     * Название очереди создания блюд
     */
    @Value("\${rabbitmq.queue.menu.created}")
    lateinit var menuCreatedQueue: String

    /**
     * Название очереди изменения блюд
     */
    @Value("\${rabbitmq.queue.menu.updated}")
    lateinit var menuUpdatedQueue: String

    /**
     * Название очереди удаления блюд
     */
    @Value("\${rabbitmq.queue.menu.deleted}")
    lateinit var menuDeletedQueue: String

    /**
     * Очередь для ответов
     */
    @Bean
    fun menuFindQueue(): Queue = Queue(menuFindQueue, true)

    /**
     * Очередь создания блюд
     */
    @Bean
    fun createQueue(): Queue = Queue(menuCreatedQueue, true)

    /**
     * Очередь изменения блю
     */
    @Bean
    fun updateQueue(): Queue = Queue(menuUpdatedQueue, true)

    /**
     * Очередь удаления блюд
     */
    @Bean
    fun deleteQueue(): Queue = Queue(menuUpdatedQueue, true)

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