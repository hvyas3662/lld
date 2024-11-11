package com.hvyas.solid.solid.ocp.shape

class Circle(private val radius: Double) : Shape {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}