package com.vadim.menuapi.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "dish")
class DishEntity (
    @Id
    @Column(name = "dish_id")
    val dishId: UUID = UUID.randomUUID(),

    @Column(name = "name")
    val name: String = ""
)