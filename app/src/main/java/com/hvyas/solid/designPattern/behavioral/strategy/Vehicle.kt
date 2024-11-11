package com.hvyas.solid.designPattern.behavioral.strategy

interface DriveProcess {
    fun drive(): String
}

class LandDriveProcess : DriveProcess {
    override fun drive(): String {
        return "engin -> chain -> tyair"
    }
}

class WaterDriveProcess : DriveProcess {
    override fun drive(): String {
        return "engin -> Gear -> propeller"
    }
}

abstract class Vehicle(protected val driveProcess: DriveProcess) {
    abstract fun drive()
}

//don't have to define land vehicle process twice so my abstraction and its implatation is different
class Car : Vehicle(LandDriveProcess()) {
    override fun drive() {
        println(driveProcess.drive())
    }
}

class Bike : Vehicle(LandDriveProcess()) {
    override fun drive() {
        println(driveProcess.drive())
    }
}

class Boat : Vehicle(WaterDriveProcess()) {
    override fun drive() {
        println(driveProcess.drive())
    }
}


fun main() {
    Car().drive()
    Bike().drive()
    Boat().drive()
}