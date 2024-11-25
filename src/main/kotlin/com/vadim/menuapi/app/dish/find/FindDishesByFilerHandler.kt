package com.vadim.menuapi.app.dish.find

import com.vadim.menuapi.cqrs.annotation.Handler
import com.vadim.menuapi.cqrs.query.QueryHandler
import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.find.FindDishesByFilerQuery


@Handler
class FindDishesByFilerHandler(
    private val findDishesByFilterUseCase: FindDishesByFilterUseCase
): QueryHandler<FindDishesByFilerQuery, Collection<Dish>> {
    override fun handle(query: FindDishesByFilerQuery): Collection<Dish> =
        findDishesByFilterUseCase.execute(query.findDishesFilter)
}