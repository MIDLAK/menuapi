package com.vadim.menuapi.cqrs.command

interface CommandHandler<C: Command<R>, R> {
    fun handle(command: C): R
}