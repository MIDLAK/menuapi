package com.vadim.menuapi.amqp

import com.vadim.menuapi.common.dish.create.CreateDishDto
import com.vadim.menuapi.common.dish.find.FindDishesDto
import com.vadim.menuapi.common.dish.update.UpdateDishDto
import com.vadim.menuapi.cqrs.command.CommandBus
import com.vadim.menuapi.cqrs.query.QueryBus
import com.vadim.menuapi.domain.dish.Dish
import com.vadim.menuapi.domain.dish.create.CreateDishCommand
import com.vadim.menuapi.domain.dish.create.NewDishParams
import com.vadim.menuapi.domain.dish.delete.DeleteDishCommand
import com.vadim.menuapi.domain.dish.find.FindDishesByFilerQuery
import com.vadim.menuapi.domain.dish.find.FindAllDishesQuery
import com.vadim.menuapi.domain.dish.find.FindDishesFilter
import com.vadim.menuapi.domain.dish.update.DishUpdate
import com.vadim.menuapi.domain.dish.update.UpdateDishCommand
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service
import java.util.*


@Service
class DishController(
    private val queryBus: QueryBus,
    private val commandBus: CommandBus
) {

    /**
     * Печать всех поступающих из очереди блюд для демонстрации работы
     */
    @RabbitListener(queues = ["menu_dishes"])
    fun listenAndPrint(dish: String) = println(dish)

    @RabbitListener(queues = ["menu_find"])
    fun listenFind(findDishesDto: FindDishesDto): Collection<Dish> =
        queryBus.handle(
            if (findDishesDto.findAll != null)
                FindAllDishesQuery()
            else
                FindDishesByFilerQuery(
                    findDishesFilter = FindDishesFilter(
                        dishIds = findDishesDto.dishIds
                    )
                )
        )

    @RabbitListener(queues = ["menu_create"])
    fun listenCreate(newDish: CreateDishDto): Dish =
        commandBus.handle(
            CreateDishCommand(
                newDishParams = NewDishParams(
                    name = newDish.name,
                    price = newDish.price,
                    ingredientIds = newDish.ingredientIds
                )
            )
        )

    @RabbitListener(queues = ["menu_update"])
    fun listenUpdate(dishUpdate: UpdateDishDto): Dish =
        commandBus.handle(
            UpdateDishCommand(
                dishUpdate = DishUpdate(
                    dishId = dishUpdate.dishId,
                    newIngredientIds = dishUpdate.newIngredientIds,
                    inactivatedIngredientIds = dishUpdate.deletedIngredientIds,
                    price = dishUpdate.price
                )
            )
        )

    @RabbitListener(queues = ["menu_delete"])
    fun listenDelete(dishId: UUID) =
        commandBus.handle(
            DeleteDishCommand(
                dishId = dishId
            )
        )
}