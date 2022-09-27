package com.fioneer.demo.demoservice.web

import com.fioneer.demo.demoservice.model.Cat
import com.fioneer.demo.demoservice.service.CatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CatController (
    @Autowired val catService: CatService){

    @GetMapping("/cats")
    fun getCats(): Set<Cat> {
        return catService.getCats()
    }

    @GetMapping("/catsbyage")
    fun getCatsByAge(): List<Cat> {
        return catService.getCatsSortByAge()
    }
    @GetMapping("/cattest")
    fun getCatsTest(): String {
        return "cat test"
    }
}