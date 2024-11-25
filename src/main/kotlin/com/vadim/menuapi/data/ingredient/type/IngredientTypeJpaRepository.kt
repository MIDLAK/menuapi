package com.vadim.menuapi.data.ingredient.type

import com.vadim.menuapi.domain.ingredient.type.IngredientTypeEnum
import org.springframework.data.jpa.repository.JpaRepository

interface IngredientTypeJpaRepository: JpaRepository<IngredientTypeEntity, IngredientTypeEnum>