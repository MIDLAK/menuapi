package com.vadim.menuapi.data.ingredient.type

import com.vadim.menuapi.domain.ingredient.type.IngredientType
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class IngredientTypeFactory(
    private val ingredientTypeJpaRepository: IngredientTypeJpaRepository
) {

    fun create(type: IngredientType): IngredientTypeEntity =
        IngredientTypeEntity(
            id = ingredientTypeJpaRepository.findByIdOrNull(type.id)?.id
                ?: throw RuntimeException("Ингредиент не найден"),
            name = type.name
        )
}