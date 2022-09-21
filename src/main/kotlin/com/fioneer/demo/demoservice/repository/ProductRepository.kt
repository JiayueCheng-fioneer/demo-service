package com.fioneer.demo.demoservice.repository

import com.fioneer.demo.demoservice.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long>