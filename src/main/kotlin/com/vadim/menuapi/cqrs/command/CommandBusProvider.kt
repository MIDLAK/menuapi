package com.vadim.menuapi.cqrs.command


class CommandBusProvider(private val handlers: List<Any>) : CommandBus {
    override fun <C : Command<R>, R> handle(command: C): R {
        val handler = handlers.find { it.javaClass.simpleName == "${command::class.simpleName}Handler" }
            ?: throw IllegalArgumentException("Не найден обработчик для ${command::class.simpleName}")
        val method = handler.javaClass.getMethod("handle", command::class.java)
        return method.invoke(handler, command) as R
    }
}