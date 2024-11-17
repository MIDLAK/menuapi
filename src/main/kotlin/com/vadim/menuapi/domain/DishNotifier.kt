package com.vadim.menuapi.domain

interface DishNotifier {

    fun notifyAboutDishes(queueName: String, dishes: Collection<Dish>)
}