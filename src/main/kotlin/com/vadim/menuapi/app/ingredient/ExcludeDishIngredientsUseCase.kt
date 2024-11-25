package com.vadim.menuapi.app.ingredient

import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.DishRepository
import com.vadim.menuapi.domain.ingredient.Ingredient
import com.vadim.menuapi.domain.ingredient.IngredientRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ExcludeDishIngredientsUseCase(
    private val dishRepository: DishRepository,
    private val ingredientRepository: IngredientRepository
) {

    fun executeByIds(dish: Dish, ingredientIds: Collection<UUID>): Dish =
        execute(
            dish = dish,
            ingredients = ingredientRepository.find(ingredientIds = ingredientIds)
        )

    fun execute(dish: Dish, ingredients: Collection<Ingredient>): Dish =
        dishRepository.excludeIngredients(
            dish = dish,
            ingredients = ingredients
        )
}