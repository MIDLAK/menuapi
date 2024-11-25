package com.vadim.menuapi.domain.ingredient.find

import com.vadim.menuapi.cqrs.query.Query
import com.vadim.menuapi.domain.ingredient.Ingredient

class FindAllIngredientsQuery: Query<Collection<Ingredient>>
