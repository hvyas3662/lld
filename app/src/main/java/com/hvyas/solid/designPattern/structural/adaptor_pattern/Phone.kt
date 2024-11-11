package com.hvyas.solid.designPattern.structural.adaptor_pattern

interface Socket {
    fun getElectricity(): Double
}

class WallPowerSocket : Socket {
    override fun getElectricity() = 240.0
}

//client
class Phone {
    val electricity = PhoneCharger5V(WallPowerSocket()).getElectricity()
}

interface PhoneCharger {
    fun getElectricity(): Double
}

class PhoneCharger5V(private val socket: WallPowerSocket) : PhoneCharger {
    override fun getElectricity(): Double = socket.getElectricity() - 235.0
}