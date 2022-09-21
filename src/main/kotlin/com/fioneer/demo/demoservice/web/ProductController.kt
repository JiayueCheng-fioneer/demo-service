package com.fioneer.demo.demoservice.web

import com.fioneer.demo.demoservice.model.Product
import com.fioneer.demo.demoservice.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    @Autowired val productService: ProductService
) {

    @GetMapping("/products")
    fun getProducts(): Set<Product> {
        return productService.getProducts()
    }
}