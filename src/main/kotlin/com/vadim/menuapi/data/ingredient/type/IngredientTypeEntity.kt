package com.vadim.menuapi.data.ingredient.type

import com.vadim.menuapi.domain.ingredient.type.IngredientType
import com.vadim.menuapi.domain.ingredient.type.IngredientTypeEnum
import jakarta.persistence.*

@Entity
@Table(name = "ingredient_type")
class IngredientTypeEntity(
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "ingredient_type_id")
    override val id: IngredientTypeEnum,

    @Column(name = "name")
    override val name: String
): IngredientType