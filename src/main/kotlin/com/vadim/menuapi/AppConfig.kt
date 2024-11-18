package com.vadim.menuapi

import com.vadim.menuapi.cqrs.HandlerRegistry
import com.vadim.menuapi.cqrs.command.CommandBus
import com.vadim.menuapi.cqrs.command.CommandBusProvider
import com.vadim.menuapi.cqrs.query.QueryBus
import com.vadim.menuapi.cqrs.query.QueryBusProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun commandBus(handlerRegistry: HandlerRegistry): CommandBus {
        val handlers = handlerRegistry.getHandlers()
        return CommandBusProvider(handlers)
    }

    @Bean
    fun queryBus(handlerRegistry: HandlerRegistry): QueryBus {
        val handlers = handlerRegistry.getHandlers()
        return QueryBusProvider(handlers)
    }
}
