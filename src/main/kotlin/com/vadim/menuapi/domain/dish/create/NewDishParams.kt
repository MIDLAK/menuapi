package com.vadim.menuapi.domain.dish.create

import java.util.*

class NewDishParams(
    val name: String,
    val price: Double,
    val ingredientIds: Collection<UUID>
)