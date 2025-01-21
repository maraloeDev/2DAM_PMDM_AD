package com.example.examenzumos

class PrecioZumos(val nombre:String, val precio:Int) {

    override fun toString(): String {
        return "$nombre - $precio €"
    }
}