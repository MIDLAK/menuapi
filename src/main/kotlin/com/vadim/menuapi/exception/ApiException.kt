package com.vadim.menuapi.exception

import org.springframework.http.HttpStatus

/**
 * Исключение приложения
 */
abstract class ApiException(
    /**
     * HTTP-статус
     */
    val httpStatus: HttpStatus,

    /**
     * Ошибка
     */
    val apiError: ApiError
): RuntimeException(apiError.description)