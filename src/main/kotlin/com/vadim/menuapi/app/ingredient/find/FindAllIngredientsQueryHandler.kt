package com.vadim.menuapi.app.ingredient.find

import com.vadim.menuapi.cqrs.annotation.Handler
import com.vadim.menuapi.cqrs.query.QueryHandler
import com.vadim.menuapi.domain.ingredient.Ingredient
import com.vadim.menuapi.domain.ingredient.find.FindAllIngredientsQuery

@Handler
class FindAllIngredientsQueryHandler(
    private val findAllIngredientsUseCase: FindAllIngredientsUseCase
): QueryHandler<FindAllIngredientsQuery, Collection<Ingredient>> {
    override fun handle(query: FindAllIngredientsQuery): Collection<Ingredient> =
        findAllIngredientsUseCase.execute()
}