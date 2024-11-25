package com.vadim.menuapi.common.dish.find

import java.util.UUID

data class FindDishesDto(
    val dishIds: Collection<UUID>,
    val findAll: Boolean? = null
)