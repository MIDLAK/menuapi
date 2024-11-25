package com.vadim.menuapi.data.dish

import com.vadim.menuapi.data.ingredient.IngredientEntity
import com.vadim.menuapi.data.ingredient.IngredientFactory
import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.DishRepository
import com.vadim.menuapi.domain.dish.create.NewDishParams
import com.vadim.menuapi.domain.ingredient.Ingredient
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.*

@Component
class DishRepositoryImpl(
    private val dishJpaRepository: DishJpaRepository,
    private val dishFactory: DishFactory,
    private val ingredientFactory: IngredientFactory
): DishRepository {

    override fun save(dish: Dish): Dish =
        dishJpaRepository.save(
            if (dish is DishEntity) dish else dishFactory.create(dish)
        )

    override fun save(newDishParams: NewDishParams): Dish =
        dishJpaRepository.save(dishFactory.create(newDishParams))

    @Cacheable("findAllDishesCache")
    override fun findAllDishes(): Collection<Dish> =
        dishJpaRepository.findAll()

    override fun find(dishId: UUID): Dish = find(listOf(dishId)).single()

    override fun find(dishIds: Collection<UUID>): Collection<Dish> =
        dishJpaRepository.findAllById(dishIds)

    override fun addIngredients(dish: Dish, ingredients: Collection<Ingredient>): Dish {
        val dishEntity: DishEntity = dishJpaRepository.findByIdOrNull(dish.id)
            ?: throw RuntimeException("Блюдо не найдено")

        ingredients.map {
            dishEntity.ingredients.add(
                if (it is IngredientEntity) it else ingredientFactory.create(it)
            )
        }

        return dishJpaRepository.saveAndFlush(dishEntity)
    }

    override fun excludeIngredients(dish: Dish, ingredients: Collection<Ingredient>): Dish {
        val dishEntity: DishEntity = dishJpaRepository.findByIdOrNull(dish.id)
            ?: throw RuntimeException("Блюдо не найдено")

        ingredients.map {
            dishEntity.ingredients.removeIf {
                it.id in ingredients.map { it.id }
            }
        }

        return dishJpaRepository.saveAndFlush(dishEntity)
    }
}