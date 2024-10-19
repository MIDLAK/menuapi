package com.vadim.menuapi.service

import com.vadim.menuapi.dto.DishDto
import com.vadim.menuapi.amqp.DishProducer
import com.vadim.menuapi.repository.DishRepository
import com.vadim.menuapi.service.DishMapper.toDto
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class DishServiceImpl(
    private val dishRepository: DishRepository,
    private val dishProducer: DishProducer
): DishService {

    @Cacheable("dishesCache")
    override fun getAll(): Collection<DishDto> = dishRepository.findAll().map { it.toDto() }

    override fun sendAllDishes() = dishProducer.sendDishes(getAll())
}