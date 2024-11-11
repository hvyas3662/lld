package com.hvyas.solid.designPattern.behavioral.commond

import java.util.Stack

//client
fun main() {
    val ac = Ac()
    val remote = AcRemote()
    remote.setCommand(TurnOnAcCommand(ac))
    remote.pressButton()
    remote.undo()
}

class AcRemote {
    private val stack:Stack<ICommand> = Stack()
    private var command: ICommand? = null

    fun setCommand(command: ICommand) {
        this.command = command
        stack.push(command)
    }

    fun pressButton() {
        command?.execute()
    }

    fun undo(){
        stack.pop().undo()
    }
}


interface ICommand {
    fun execute()
    fun undo()
}

class TurnOnAcCommand(private val ac: Ac) : ICommand {
    override fun execute() {
        ac.turnOnAc()
    }

    override fun undo() {
       ac.turnOff()
    }
}

class TurnOffAcCommand(private val ac: Ac) : ICommand {
    override fun execute() {
        ac.turnOff()
    }

    override fun undo() {
       ac.turnOnAc()
    }
}

class SetTempCommand(private val ac: Ac, private val temp: Int) : ICommand {
    var prevTemp = ac.temprature
    override fun execute() {
        ac.setTemp(temp)
    }

    override fun undo() {
        ac.setTemp(prevTemp)
    }
}

//Receiver
class Ac {
    private var isOn: Boolean = false
    var temprature: Int = 0

    fun turnOnAc() {
        isOn = true
    }

    fun turnOff() {
        isOn = false
    }

    fun setTemp(temp: Int) {
        this.temprature = temp
    }
}