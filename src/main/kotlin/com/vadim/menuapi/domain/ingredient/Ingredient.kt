package com.vadim.menuapi.domain.ingredient

import com.vadim.menuapi.domain.ingredient.type.IngredientType
import java.util.*

/**
 * Ингридиент блюда
 */
interface Ingredient {
    /**
     * УИД ингридиента
     */
    val id: UUID

    /**
     * Название ингридиента
     */
    val name: String

    /**
     * Стоимость ингридиента
     */
    val price: Double

    /**
     * Тип ингридиента
     */
    val type: IngredientType
}