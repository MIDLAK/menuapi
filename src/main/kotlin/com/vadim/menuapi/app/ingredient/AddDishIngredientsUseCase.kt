package com.vadim.menuapi.app.ingredient

import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.DishRepository
import com.vadim.menuapi.domain.ingredient.Ingredient
import com.vadim.menuapi.domain.ingredient.IngredientRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class AddDishIngredientsUseCase(
    private val ingredientRepository: IngredientRepository,
    private val dishRepository: DishRepository
) {

    fun executeByIds(dish: Dish, ingredientIds: Collection<UUID>): Dish =
        execute(
            dish = dish,
            ingredients = ingredientRepository.find(ingredientIds = ingredientIds)
        )

    fun execute(dish: Dish, ingredients: Collection<Ingredient>): Dish =
        dishRepository.addIngredients(
            dish = dish,
            ingredients = ingredientsDistinct(dish = dish, ingredients = ingredients)
        )


    /**
     * Исключает из добавляемых ингридиентов уже присутсвующие
     */
    private fun ingredientsDistinct(
        dish: Dish,
        ingredients: Collection<Ingredient>
    ): Collection<Ingredient> =
        ingredients.distinctBy { it.id !in dish.ingredients.map { ingredient -> ingredient.id } }
}