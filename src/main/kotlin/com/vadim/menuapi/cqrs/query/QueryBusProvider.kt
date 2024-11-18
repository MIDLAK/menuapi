package com.vadim.menuapi.cqrs.query

class QueryBusProvider(private val handlers: List<Any>) : QueryBus {
    override fun <Q : Query<R>, R> handle(query: Q): R {
        val handler = handlers.find { it.javaClass.simpleName == "${query::class.simpleName}Handler" }
            ?: throw IllegalArgumentException("Handler not found for ${query::class.simpleName}")
        val method = handler.javaClass.getMethod("handle", query::class.java)
        return method.invoke(handler, query) as R
    }
}