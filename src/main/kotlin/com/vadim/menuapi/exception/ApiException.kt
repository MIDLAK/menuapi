package com.vadim.menuapi.exception

import org.springframework.http.HttpStatus

abstract class ApiException(
    val httpStatus: HttpStatus,
    val apiError: ApiError
): RuntimeException(apiError.description)