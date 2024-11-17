package com.vadim.menuapi.cqrs

import com.vadim.menuapi.cqrs.annotation.Handler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component

@Component
class HandlerRegistry(@Autowired val context: ApplicationContext) {

    fun getHandlers(): List<Any> {
        return context.getBeansWithAnnotation(Handler::class.java).values.toList()
    }
}
