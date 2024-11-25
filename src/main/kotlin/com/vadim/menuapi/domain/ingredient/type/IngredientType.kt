package com.vadim.menuapi.domain.ingredient.type

/**
 * Тип ингридиента
 */
interface IngredientType {
    /**
     * УИД типа
     */
    val id: IngredientTypeEnum

    /**
     * Наименование
     */
    val name: String
}