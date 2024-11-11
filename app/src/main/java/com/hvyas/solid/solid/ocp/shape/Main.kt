package com.hvyas.solid.solid.ocp.shape

class Main {

    fun main() {
        val circle = Circle(5.0)
        val square = Square(4.0)

        val calculator = AreaCalculator()

        println("Circle area: ${calculator.calculate(circle)}")
        println("Square area: ${calculator.calculate(square)}")
    }
}