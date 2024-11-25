package com.vadim.menuapi.data.ingredient

import com.vadim.menuapi.data.ingredient.type.IngredientTypeEntity
import com.vadim.menuapi.domain.ingredient.Ingredient
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "ingredient")
class IngredientEntity(
    @Id
    @Column(name = "ingredient_id")
    override val id: UUID = UUID.randomUUID(),

    @Column(name = "name")
    override val name: String,

    @Column(name = "price")
    override val price: Double,

    @ManyToOne
    @JoinColumn(name = "type")
    override val type: IngredientTypeEntity
) : Ingredient