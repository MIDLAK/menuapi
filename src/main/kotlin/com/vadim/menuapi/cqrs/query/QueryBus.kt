package com.vadim.menuapi.cqrs.query

interface QueryBus {
    fun <Q: Query<R>, R> handle(query: Q): R
}