package com.vadim.menuapi.amqp.dish

import com.vadim.menuapi.common.dish.DishDto
import com.vadim.menuapi.common.dish.DishMapper.toDto
import com.vadim.menuapi.common.dish.create.CreateDishDto
import com.vadim.menuapi.common.dish.find.FindDishesDto
import com.vadim.menuapi.common.dish.update.UpdateDishDto
import com.vadim.menuapi.cqrs.command.CommandBus
import com.vadim.menuapi.cqrs.query.QueryBus
import com.vadim.menuapi.domain.dish.create.CreateDishCommand
import com.vadim.menuapi.domain.dish.create.NewDishParams
import com.vadim.menuapi.domain.dish.delete.DeleteDishCommand
import com.vadim.menuapi.domain.dish.find.FindAllDishesQuery
import com.vadim.menuapi.domain.dish.find.FindDishesByFilerQuery
import com.vadim.menuapi.domain.dish.find.FindDishesFilter
import com.vadim.menuapi.domain.dish.update.DishUpdate
import com.vadim.menuapi.domain.dish.update.UpdateDishCommand
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Controller
import java.util.*


@Controller
@RabbitListener(queues = ["dish_request"])
class DishController(
    private val queryBus: QueryBus,
    private val commandBus: CommandBus
) {
    @RabbitHandler
    fun listenFind(findDishesDto: FindDishesDto): Collection<DishDto> =
        queryBus.handle(
            if (findDishesDto.findAll != null)
                FindAllDishesQuery()
            else
                FindDishesByFilerQuery(
                    findDishesFilter = FindDishesFilter(
                        dishIds = findDishesDto.dishIds ?: listOf()
                    )
                )
        ).toDto()

    @RabbitHandler
    fun listenCreate(newDish: CreateDishDto): DishDto =
        commandBus.handle(
            CreateDishCommand(
                newDishParams = NewDishParams(
                    name = newDish.name,
                    price = newDish.price,
                    ingredientIds = newDish.ingredientIds
                )
            )
        ).toDto()

    @RabbitHandler
    fun listenUpdate(dishUpdate: UpdateDishDto): DishDto =
        commandBus.handle(
            UpdateDishCommand(
                dishUpdate = DishUpdate(
                    dishId = dishUpdate.dishId,
                    newIngredientIds = dishUpdate.newIngredientIds,
                    inactivatedIngredientIds = dishUpdate.deletedIngredientIds,
                    price = dishUpdate.price
                )
            )
        ).toDto()

    @RabbitHandler
    fun listenDelete(dishId: UUID) =
        commandBus.handle(
            DeleteDishCommand(
                dishId = dishId
            )
        )
}