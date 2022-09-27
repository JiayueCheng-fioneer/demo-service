package com.fioneer.demo.demoservice.service

import com.fioneer.demo.demoservice.model.Cat
import com.fioneer.demo.demoservice.repository.CatRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CatService(
    @Autowired val catRepository: CatRepository
    ) {
    fun getCats(): Set<Cat> {
        return catRepository.findAll().toSet()
    }
    fun getCatsSortByAge(): List<Cat> {
        return catRepository.findAll().sortedWith(compareBy { it.getAge() })
    }
}