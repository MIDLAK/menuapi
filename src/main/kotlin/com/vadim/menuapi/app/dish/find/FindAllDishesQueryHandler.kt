package com.vadim.menuapi.app.dish.find

import com.vadim.menuapi.cqrs.annotation.Handler
import com.vadim.menuapi.cqrs.query.QueryHandler
import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.find.FindAllDishesQuery

@Handler
class FindAllDishesQueryHandler(
    private val findAllDishesUseCase: FindAllDishesUseCase
): QueryHandler<FindAllDishesQuery, Collection<Dish>> {
    override fun handle(query: FindAllDishesQuery): Collection<Dish> =
        findAllDishesUseCase.execute()
}