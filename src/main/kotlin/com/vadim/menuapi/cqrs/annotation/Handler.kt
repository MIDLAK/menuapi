package com.vadim.menuapi.cqrs.annotation

import org.springframework.stereotype.Component

@Component
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Handler
