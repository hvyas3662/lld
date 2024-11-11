package com.hvyas.solid.designPattern.structural.bridge_pattern

interface BreathProcess {
    fun breath(): String
}

class LandBreathProcess : BreathProcess {
    override fun breath(): String {
        return "nose -> o2 ->co2"
    }
}

class WaterBreathProcess : BreathProcess {
    override fun breath(): String {
        return "gills -> o2 -> co2"
    }
}

class TreeBreathProcess : BreathProcess {
    override fun breath(): String {
        return "leaves -> co2 -> o2"
    }
}

abstract class LivingThings(protected val breathProcess: BreathProcess) {
    var isAlive: Boolean = true
    abstract fun doBreathProcess()
}

//don't have to define land breath process twice so my abstraction and its implatation is different
class Human : LivingThings(LandBreathProcess()) {
    override fun doBreathProcess() {
        breathProcess.breath()
    }
}

class Dog : LivingThings(LandBreathProcess()) {
    override fun doBreathProcess() {
        breathProcess.breath()
    }
}

class Fish : LivingThings(WaterBreathProcess()) {
    override fun doBreathProcess() {
        breathProcess.breath()
    }
}

class MangoTree : LivingThings((TreeBreathProcess())) {
    override fun doBreathProcess() {
        breathProcess.breath()
    }
}

fun main() {
    val mangoTree = MangoTree()

    var breathCount = 0
    while (mangoTree.isAlive) {
        Thread.sleep(5000)
        if (breathCount <= 10000) {
            mangoTree.doBreathProcess()
            breathCount++
        } else {
            mangoTree.isAlive = false
        }
    }
}