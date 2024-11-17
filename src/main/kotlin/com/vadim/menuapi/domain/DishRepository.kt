package com.vadim.menuapi.domain

/**
 * Хранилище блюд
 */
interface DishRepository {
    fun findAllDishes(): Collection<Dish>
}