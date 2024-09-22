package com.vadim.menuapi.service

import com.vadim.menuapi.dto.DishDto

interface DishService {
    fun getAll(): Collection<DishDto>
}