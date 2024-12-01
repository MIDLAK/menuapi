package com.vadim.menuapi.data.dish

import com.vadim.menuapi.data.ingredient.IngredientJpaRepository
import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.create.NewDishParams
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class DishFactory(
    private val dishJpaRepository: DishJpaRepository,
    private val ingredientJpaRepository: IngredientJpaRepository
) {

    fun create(newDishParams: NewDishParams): DishEntity =
        DishEntity(
            name = newDishParams.name,
            price = newDishParams.price,
            ingredients = ingredientJpaRepository.findAllById(newDishParams.ingredientIds)
        )

    fun create(dish: Dish): DishEntity =
        DishEntity(
            id = dishJpaRepository.findByIdOrNull(dish.id)?.id
                ?: throw RuntimeException("Блюдо не найдено"),
            name = dish.name,
            price = dish.price,
            isActive = dish.isActive
        )
}