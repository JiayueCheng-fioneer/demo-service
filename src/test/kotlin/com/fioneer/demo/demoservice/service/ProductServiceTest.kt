package com.fioneer.demo.demoservice.service

import com.fioneer.demo.demoservice.model.Product
import com.fioneer.demo.demoservice.repository.ProductRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class ProductServiceTest : StringSpec({

    val expectedProducts =
        listOf(Product(id = 1, name = "Product1", version = 1), Product(id = 2, name = "Product2", version = 2))

    val mockProductRepository: ProductRepository = mock {
        on { findAll() } doReturn expectedProducts
    }

    val productService = ProductService(mockProductRepository)

    "should get all products" {
        val actualProducts = productService.getProducts()
        actualProducts shouldBe expectedProducts
    }
})