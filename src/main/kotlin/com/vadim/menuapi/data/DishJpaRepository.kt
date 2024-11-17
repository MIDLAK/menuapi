package com.vadim.menuapi.data

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface DishJpaRepository: JpaRepository<DishEntity, UUID>