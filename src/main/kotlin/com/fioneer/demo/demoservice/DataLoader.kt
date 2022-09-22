package com.fioneer.demo.demoservice

import com.fioneer.demo.demoservice.model.Product
import com.fioneer.demo.demoservice.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(
    @Autowired val productRepository: ProductRepository
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
    }
    override fun run(vararg args: String?) {

        productRepository.saveAll(products)
    }
}