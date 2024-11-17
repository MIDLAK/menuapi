package com.vadim.menuapi.cqrs.command

interface CommandBus {
    fun <C: Command<R>, R> handle(command: C): R
}
