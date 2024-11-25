package com.vadim.menuapi.domain.ingredient

import java.util.*

/**
 * Хранилище ингридиентов
 */
interface IngredientRepository {

    /**
     * Поиск игридиентов
     */
    fun find(ingredientIds: Collection<UUID>): Collection<Ingredient>

    /**
     * Поиск всех ингридиентов
     */
    fun findAll(): Collection<Ingredient>
}