package com.fioneer.demo.demoservice.repository

import com.fioneer.demo.demoservice.DataLoader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductRepositoryIT(
    @Autowired val productRepository: ProductRepository
) {
    @Test
    fun `should find all products`() {
        val actualProducts = productRepository.findAll()
        assertEquals(3, actualProducts.size)
        assertTrue(actualProducts.containsAll(DataLoader.products))
    }
}