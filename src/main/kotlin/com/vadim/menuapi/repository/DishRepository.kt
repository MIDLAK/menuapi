package com.vadim.menuapi.repository

import com.vadim.menuapi.entity.DishEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

/**
 * Хранилище блюд
 */
interface DishRepository : CrudRepository<DishEntity, UUID>