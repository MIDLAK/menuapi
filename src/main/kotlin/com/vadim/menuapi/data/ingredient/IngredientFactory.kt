package com.vadim.menuapi.data.ingredient

import com.vadim.menuapi.data.ingredient.type.IngredientTypeFactory
import com.vadim.menuapi.domain.ingredient.Ingredient
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class IngredientFactory(
    private val ingredientJpaRepository: IngredientJpaRepository,
    private val ingredientTypeFactory: IngredientTypeFactory
) {

    fun create(ingredients: Collection<Ingredient>): Collection<IngredientEntity> =
        ingredients.map { create(it) }

    fun create(ingredient: Ingredient): IngredientEntity =
        IngredientEntity(
            id = ingredientJpaRepository.findByIdOrNull(ingredient.id)?.id
                ?: throw RuntimeException("Ингредиент не найден"),
            name = ingredient.name,
            price = ingredient.price,
            type = ingredientTypeFactory.create(ingredient.type)
        )
}