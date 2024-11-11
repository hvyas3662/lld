package com.hvyas.solid.designPattern.structural.decorator_pattern


interface Pizza {
    fun cost(): Int
}

class Margherita : Pizza {
    override fun cost() = 100
}

class FarmHouse : Pizza {
    override fun cost() = 150
}

class TandooriPizza : Pizza {
    override fun cost() = 200
}

abstract class ToppingDecorator(protected val basePizza: Pizza) : Pizza

class ExtraCheese(basePizza: Pizza) : ToppingDecorator(basePizza) {
    override fun cost() = basePizza.cost() + 50
}

class OnionTopping(basePizza: Pizza) : ToppingDecorator(basePizza) {
    override fun cost() = basePizza.cost() + 50
}

class TomatoTopping(basePizza: Pizza) : ToppingDecorator(basePizza) {
    override fun cost() = basePizza.cost() + 50
}

class MushRoomTopping(basePizza: Pizza) : ToppingDecorator(basePizza) {
    override fun cost() = basePizza.cost() + 50
}

fun main() {
    val pizza = MushRoomTopping(TomatoTopping(OnionTopping(FarmHouse())))
    println(pizza.cost())
}