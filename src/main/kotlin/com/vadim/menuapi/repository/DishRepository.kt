package com.vadim.menuapi.repository

import com.vadim.menuapi.entity.DishEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface DishRepository : CrudRepository<DishEntity, UUID>