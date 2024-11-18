package com.vadim.menuapi.app

import com.vadim.menuapi.cqrs.annotation.Handler
import com.vadim.menuapi.cqrs.query.QueryHandler
import com.vadim.menuapi.domain.*
import org.springframework.stereotype.Component

@Handler
class FindAllDishesQueryHandler(
    private val dishRepository: DishRepository,
    private val dishNotifier: DishNotifier
): QueryHandler<FindAllDishesQuery, Collection<Dish>> {

    override fun handle(query: FindAllDishesQuery): Collection<Dish> =
        dishRepository.findAllDishes().also {
            dishNotifier.notifyAboutDishes(queueName = "menu_dishes", dishes = it)
        }
}