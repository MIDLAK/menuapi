package com.vadim.menuapi.data.ingredient

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface IngredientJpaRepository: JpaRepository<IngredientEntity, UUID>