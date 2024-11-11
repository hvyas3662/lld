package com.hvyas.solid.solid.ocp.shape

class Square(private val side:Double) :Shape{
    override fun area(): Double {
        return side *side;
    }
}
