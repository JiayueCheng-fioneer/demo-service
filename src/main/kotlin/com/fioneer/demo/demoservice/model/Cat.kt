package com.fioneer.demo.demoservice.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
open class Cat (
    @Id
    @GeneratedValue
    private val id: Long = 0L,
    private var name: String?,
    private var age: Number?,
    private val colour: String?,
    private val sex: String?,
    private var mood: String?,
){
    override fun toString(): String {
        return "Cat(id=$id, name=$name, age=$age, colour=$colour, sex=$sex, mood=$mood)"
    }
    fun getId(): Long {
        return this.id
    }

    fun getName(): String? {
        return this.name
    }

    fun getPets(): String{
        if(this.mood != "happy") {
            this.mood = "happy"
        }
        return "You petted the cat! $name is now $mood and purring!"
    }

    fun setMood(mood: String): String{
        this.mood = mood
        return "Mood set to$mood. Cat is now $this"
    }

    fun reName(name: String): String{
        this.name = name
        return "Name set to$name. Cat is now $this"
    }
    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(javaClass != other?.javaClass) return false

        other as Cat
        if (id != other.id) return false
        if (name != other.name) return false
        if (age != other.age) return false
        if (colour != other.colour) return false
        if (sex != other.sex) return false
        if (mood != other.mood) return false

        return true
    }
    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }

}
