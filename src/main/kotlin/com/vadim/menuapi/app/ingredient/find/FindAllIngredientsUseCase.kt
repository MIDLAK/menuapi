package com.vadim.menuapi.app.ingredient.find

import com.vadim.menuapi.domain.ingredient.Ingredient
import com.vadim.menuapi.domain.ingredient.IngredientRepository
import org.springframework.stereotype.Component

@Component
class FindAllIngredientsUseCase(
    private val ingredientRepository: IngredientRepository
) {
    fun execute(): Collection<Ingredient> =
        ingredientRepository.findAll()
}