package com.vadim.menuapi.domain

import com.vadim.menuapi.cqrs.query.Query

class FindAllDishesQuery: Query<Collection<Dish>>
