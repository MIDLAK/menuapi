package com.vadim.menuapi.data.ingredient

import com.vadim.menuapi.domain.ingredient.Ingredient
import com.vadim.menuapi.domain.ingredient.IngredientRepository
import java.util.*

class IngredientRepositoryImpl(
    private val ingredientJpaRepository: IngredientJpaRepository
): IngredientRepository {

    override fun find(ingredientIds: Collection<UUID>): Collection<Ingredient> =
        ingredientJpaRepository.findAllById(ingredientIds)

    override fun findAll(): Collection<Ingredient> =
        ingredientJpaRepository.findAll()
}