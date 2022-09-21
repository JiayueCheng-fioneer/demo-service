package com.fioneer.demo.demoservice.service

import com.fioneer.demo.demoservice.model.Product
import com.fioneer.demo.demoservice.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService(
    @Autowired val productRepository: ProductRepository
) {

    fun getProducts(): Set<Product> {
        return productRepository.findAll().toSet()
    }
}