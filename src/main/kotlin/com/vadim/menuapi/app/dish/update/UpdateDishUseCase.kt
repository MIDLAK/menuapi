package com.vadim.menuapi.app.dish.update

import com.vadim.menuapi.app.ingredient.AddDishIngredientsUseCase
import com.vadim.menuapi.app.ingredient.ExcludeDishIngredientsUseCase
import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.DishRepository
import com.vadim.menuapi.domain.dish.update.DishUpdate
import org.springframework.stereotype.Component

@Component
class UpdateDishUseCase(
    private val dishRepository: DishRepository,
    private val addDishIngredientsUseCase: AddDishIngredientsUseCase,
    private val excludeDishIngredientsUseCase: ExcludeDishIngredientsUseCase
) {

    fun execute(dishUpdate: DishUpdate): Dish {
        val dish: Dish = dishRepository.find(dishUpdate.dishId)
        dishUpdate.addIngredients(dish)
            .excludeIngredients(dish)
            .updatePrice(dish)
        return dish
    }

    fun DishUpdate.addIngredients(dish: Dish): DishUpdate =
        apply {
            this.newIngredientIds?.let {
                addDishIngredientsUseCase.executeByIds(
                    dish = dish,
                    ingredientIds = it
                )
            }
        }

    fun DishUpdate.excludeIngredients(dish: Dish): DishUpdate =
        apply {
            this.inactivatedIngredientIds?.let {
                excludeDishIngredientsUseCase.executeByIds(
                    dish = dish,
                    ingredientIds = it
                )
            }
        }

    fun DishUpdate.updatePrice(dish: Dish): DishUpdate =
        apply {
            this.price?.let {
                dishRepository.save(
                    dish.apply { this.price = it }
                )
            }
        }
}