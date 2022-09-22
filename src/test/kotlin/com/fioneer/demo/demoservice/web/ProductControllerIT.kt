package com.fioneer.demo.demoservice.web

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fioneer.demo.demoservice.model.Product
import com.fioneer.demo.demoservice.service.ProductService
import org.junit.jupiter.api.Test
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class ProductControllerIT(
    @Autowired val webTestClient: WebTestClient
) {
    @MockBean
    lateinit var productService: ProductService

    @Test
    fun `should find and return all products`() {
        val products =
            setOf(Product(id = 1, name = "Product1", version = 1), Product(id = 2, name = "Product2", version = 2))
        whenever(productService.getProducts()).thenReturn(products)
        webTestClient
            .get().uri("/products")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .json(jacksonObjectMapper().writeValueAsString(products))
        verify(productService, times(1)).getProducts()
    }
}