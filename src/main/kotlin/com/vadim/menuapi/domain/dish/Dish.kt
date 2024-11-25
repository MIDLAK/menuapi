package com.vadim.menuapi.domain.dish

import com.vadim.menuapi.domain.ingredient.Ingredient
import java.util.*

/**
 * Блюдо
 */
interface Dish {
    /**
     * УИД блюда
     */
    val id: UUID

    /**
     * Наименование блюда
     */
    val name: String

    /**
     * Цена блюда
     */
    var price: Double

    /**
     * Ингридиенты
     */
    val ingredients: Collection<Ingredient>

    var isActive: Boolean
}