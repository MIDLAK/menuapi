package com.vadim.menuapi.exception

/**
 * Ошибка приложения
 */
data class ApiError(
    /**
     * Код ошибки
     */
    val code: String,

    /**
     * Описание ошибки
     */
    val description: String
)