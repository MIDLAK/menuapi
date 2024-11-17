package com.vadim.menuapi.cqrs.query

interface QueryHandler<Q: Query<R>, R> {
    fun handle(query: Q): R
}