package com.vadim.menuapi.data

import com.vadim.menuapi.domain.Dish
import com.vadim.menuapi.domain.DishRepository
import org.springframework.stereotype.Component

@Component
class DishRepositoryImpl(
    private val dishJpaRepository: DishJpaRepository
): DishRepository {
    override fun findAllDishes(): Collection<Dish> =
        dishJpaRepository.findAll()
}