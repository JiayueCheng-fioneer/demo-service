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
) {
    override fun toString(): String {
        return "Product(id=$id, name=$name, version=$version)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false
        if (name != other.name) return false
        if (version != other.version) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (version ?: 0)
        return result
    }
}