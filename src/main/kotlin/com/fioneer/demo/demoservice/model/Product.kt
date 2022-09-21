package com.fioneer.demo.demoservice.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
open class Product(
    @Id
    @GeneratedValue
    open val id: Long = 0L,
    open var name: String?,
    open var version: Int?,
)