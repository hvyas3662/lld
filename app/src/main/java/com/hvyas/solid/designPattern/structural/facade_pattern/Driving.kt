package com.hvyas.solid.designPattern.structural.facade_pattern

class Engin {
    fun ignite() {

    }
}

class Wheel {
    fun rotate() {

    }
}

class Breaks {
    fun apply() {

    }
}

class DrivingFaced {
    private var lastSpeed = 0

    private val engin = Engin()
    private val breaks = Breaks()
    private val wheel = Wheel()
    fun changeSpeed(speed: Int) {
        if (lastSpeed != speed) {
            if (lastSpeed > speed) {
                breaks.apply()
            } else {
                engin.ignite()
            }
            wheel.rotate()
            lastSpeed = speed
        }
    }
}


fun main() {
    DrivingFaced().changeSpeed(12)
}