package com.vadim.menuapi.common.dish.find

import java.util.UUID

data class FindDishesDto(
    val dishIds: Collection<UUID>? = null,
    val findAll: Boolean? = null
)