package com.vadim.menuapi.domain.dish

import com.vadim.menuapi.domain.dish.create.NewDishParams
import com.vadim.menuapi.domain.ingredient.Ingredient
import java.util.UUID

/**
 * Хранилище блюд
 */
interface DishRepository {

    /**
     * Сохранение блюда
     */
    fun save(dish: Dish): Dish

    /**
     * Сохранение нового блюда
     */
    fun save(newDishParams: NewDishParams): Dish

    /**
     * Поиск всех доступных блюд
     */
    fun findAllDishes(): Collection<Dish>

    /**
     * Поиск блюда
     */
    fun find(dishId: UUID): Dish

    /**
     * Поиск блюд
     */
    fun find(dishIds: Collection<UUID>): Collection<Dish>

    /**
     * Добавление ингредиентов
     */
    fun addIngredients(dish: Dish, ingredients: Collection<Ingredient>): Dish

    /**
     * Исключение ингредиентов
     */
    fun excludeIngredients(dish: Dish, ingredients: Collection<Ingredient>): Dish
}