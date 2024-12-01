package com.vadim.menuapi.data.dish

import com.vadim.menuapi.data.ingredient.IngredientEntity
import com.vadim.menuapi.domain.dish.Dish
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "dish")
class DishEntity (
    @Id
    @Column(name = "dish_id")
    override val id: UUID = UUID.randomUUID(),

    @Column(name = "name")
    override val name: String,

    @Column(name = "price")
    override var price: Double,

    @ManyToMany
    @JoinTable(
        name = "dish_ingredient",
        joinColumns = [JoinColumn(name = "dish_id")],
        inverseJoinColumns = [JoinColumn(name = "ingredient_id")]
    )
    override val ingredients: MutableCollection<IngredientEntity> = mutableListOf(),

    @Column(name = "is_active")
    override var isActive: Boolean = true
): Dish