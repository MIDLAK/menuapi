package com.vadim.menuapi.data.dish

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface DishJpaRepository: JpaRepository<DishEntity, UUID> {
    @EntityGraph(attributePaths = ["ingredients"])
    override fun findAll(): MutableList<DishEntity>
}