package com.fioneer.demo.demoservice.repository

import com.fioneer.demo.demoservice.model.Cat
import org.springframework.data.jpa.repository.JpaRepository

interface CatRepository: JpaRepository<Cat, Long>