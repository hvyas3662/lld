package com.hvyas.solid.designPattern.behavioral.template_mthod

abstract class Cooking {
    abstract fun getIndegriente()
    abstract fun doCooking()
    abstract fun serveFood()

    fun cook() {
        getIndegriente()
        doCooking()
        serveFood()
    }
}


class Rajma : Cooking() {
    override fun getIndegriente() {
        TODO("Not yet implemented")
    }

    override fun doCooking() {
        TODO("Not yet implemented")
    }

    override fun serveFood() {
        TODO("Not yet implemented")
    }

}

class DalFry : Cooking() {
    override fun getIndegriente() {
        TODO("Not yet implemented")
    }

    override fun doCooking() {
        TODO("Not yet implemented")
    }

    override fun serveFood() {
        TODO("Not yet implemented")
    }

}

fun main() {
    val rajma = Rajma().cook()
    DalFry().cook()
}