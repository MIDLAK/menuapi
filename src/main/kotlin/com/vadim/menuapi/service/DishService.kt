package com.vadim.menuapi.service

import com.vadim.menuapi.dto.DishDto

/**
 * Сервис блюд
 */
interface DishService {
    /**
     * Получение всех блюд меню
     */
    fun getAll(): Collection<DishDto>

    /**
     * Отправка всех блюд меню в очередь
     */
    fun sendAllDishes()
}