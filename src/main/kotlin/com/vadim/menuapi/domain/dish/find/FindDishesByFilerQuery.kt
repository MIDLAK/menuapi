package com.vadim.menuapi.domain.dish.find

import com.vadim.menuapi.cqrs.query.Query
import com.vadim.menuapi.domain.dish.Dish


data class FindDishesByFilerQuery(
    val findDishesFilter: FindDishesFilter
): Query<Collection<Dish>>