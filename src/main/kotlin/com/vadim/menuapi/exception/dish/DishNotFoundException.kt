package com.vadim.menuapi.exception.dish

import com.vadim.menuapi.exception.ApiError
import com.vadim.menuapi.exception.ApiException
import org.springframework.http.HttpStatus

class DishNotFoundException(dishId: Int): ApiException(
    httpStatus = HttpStatus.NOT_FOUND,
    apiError = ApiError(
        code = "dish_not_found",
        description = "Блюдо id=$dishId не найдено"
    )
)