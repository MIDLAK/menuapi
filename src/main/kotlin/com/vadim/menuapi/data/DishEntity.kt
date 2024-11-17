package com.vadim.menuapi.data

import com.vadim.menuapi.domain.Dish
import jakarta.persistence.*
import java.util.UUID

/**
 * Блюдо
 */
@Entity
@Table(name = "dish")
class DishEntity (
    @Id
    @Column(name = "dish_id")
    override val dishId: UUID = UUID.randomUUID(),

    @Column(name = "name")
    override val name: String
): Dish