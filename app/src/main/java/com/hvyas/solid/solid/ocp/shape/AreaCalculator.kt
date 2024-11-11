package com.hvyas.solid.solid.ocp.shape

class AreaCalculator {
    fun calculate(shape: Shape): Double {
        return shape.area()
    }
}