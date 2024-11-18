package com.vadim.menuapi.amqp

enum class QueueNames(val queueName: String) {
    DISHES("menu_dishes"),
    DRINKS("menu_drinks")
}