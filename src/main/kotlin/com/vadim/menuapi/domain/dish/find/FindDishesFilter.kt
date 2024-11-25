package com.vadim.menuapi.domain.dish.find

import java.util.UUID

data class FindDishesFilter(
    val dishIds: Collection<UUID>
)