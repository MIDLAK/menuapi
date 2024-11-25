package com.vadim.menuapi.domain.dish.find

import com.vadim.menuapi.cqrs.query.Query
import com.vadim.menuapi.domain.dish.Dish

/**
 * Запрос всех доступных блюд
 */
class FindAllDishesQuery: Query<Collection<Dish>>
