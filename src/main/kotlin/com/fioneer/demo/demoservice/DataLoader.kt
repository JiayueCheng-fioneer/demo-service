package com.fioneer.demo.demoservice

import com.fioneer.demo.demoservice.model.Cat
import com.fioneer.demo.demoservice.model.Product
import com.fioneer.demo.demoservice.repository.CatRepository
import com.fioneer.demo.demoservice.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(
    @Autowired val productRepository: ProductRepository,
    @Autowired val catRepository: CatRepository
): CommandLineRunner {
    companion object {
        private val product1 = Product(
            name = "First Product",
            version = 1,
        )
        private val product2 = Product(
            name = "Second Product",
            version = 2,
        )
        private val product3 = Product(
            name = "Third Product",
            version = 3,
        )
        val products = setOf(product1, product2, product3)
        private val cat1 = Cat(
            name = "Bobby",
            age = 1.5,
            colour = "Brown Tabby",
            sex = "male",
            mood = "pissed"
        )
        private val cat2 = Cat(
            name = "Stormie",
            age = 0.8,
            colour = "Calico",
            sex = "female",
            mood = "excited"
        )
        private val cat3 = Cat(
            name = "Turmeric",
            age = 5.0,
            colour = "Ginger Tabby and White",
            sex = "male",
            mood = "hungry"
        )
        private val cat4 = Cat(
            name = "Snow",
            age = 15.0,
            colour = "Black",
            sex = "male",
            mood = "bored"
        )
        private val cat5 = Cat(
            name = "Genie",
            age = 5.0,
            colour = "Seal Point",
            sex = "female",
            mood = "happy"
        )
        private val cat6 = Cat(
            name = "Melon",
            age = 8.0,
            colour = "Grey",
            sex = "female",
            mood = "disappointed"
        )
        val cats = setOf(cat1, cat2, cat3, cat4, cat5, cat6)
    }
    override fun run(vararg args: String?) {
        catRepository.saveAll(cats)
        productRepository.saveAll(products)
    }
}