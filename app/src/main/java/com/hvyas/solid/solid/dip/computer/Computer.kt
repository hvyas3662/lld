package com.hvyas.solid.solid.dip.computer

class Computer(private val keyboard: InputDevice, private val mouse:InputDevice) {

    fun work(){
        keyboard.input()
        mouse.input()
    }
}