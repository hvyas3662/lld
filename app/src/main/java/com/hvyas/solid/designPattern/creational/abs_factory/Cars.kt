package com.hvyas.solid.designPattern.creational.abs_factory

interface Car {
    fun create()
}

class EcoCar1 : Car {
    override fun create() {
        TODO("Not yet implemented")
    }

}

class EcoCar2 : Car {
    override fun create() {
        TODO("Not yet implemented")
    }
}

class LuxCar : Car {
    override fun create() {
        TODO("Not yet implemented")
    }
}

class LuxCar2 : Car {
    override fun create() {
        TODO("Not yet implemented")
    }
}

class SportsCar : Car {
    override fun create() {
        TODO("Not yet implemented")
    }
}

class SportsCar1 : Car {
    override fun create() {
        TODO("Not yet implemented")
    }
}

//abstract factory
interface CarAbstractFactory {
    fun carFactory(hp: Int): Car
}

class CarFactory {
    fun create(type: String) = when (type) {
        "lux" -> LuxFactory()
        "Sports" -> SportsFactory()
        else -> EcoFactory()
    }
}

class EcoFactory : CarAbstractFactory {
    override fun carFactory(hp: Int) = if (hp < 50) EcoCar1() else EcoCar2()
}

class LuxFactory : CarAbstractFactory {
    override fun carFactory(hp: Int) = if (hp < 50) LuxCar() else LuxCar2()
}

class SportsFactory : CarAbstractFactory {
    override fun carFactory(hp: Int) = if (hp < 50) SportsCar() else SportsCar1()
}

fun main() {
    val myCar:Car = CarFactory().create("Eco").carFactory(30)
}
