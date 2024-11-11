package com.hvyas.solid.designPattern.behavioral.commond

fun main() {
    val b = Bomb()
    val r = BombRemote()
    r.setCommand(DetonateCommand(b))
    r.pressButton()
}

class BombRemote {
    private var command: BombCommand? = null

    fun setCommand(command: BombCommand) {
        this.command = command
    }

    fun pressButton() {
        command?.execute()
    }
}

interface BombCommand {
    fun execute()
}

class DetonateCommand(private val bomb: Bomb) : BombCommand {
    override fun execute() {
        bomb.detonate()
    }
}

class DefuseCommand(private val bomb: Bomb) : BombCommand {
    override fun execute() {
        bomb.defuse()
    }
}


class Bomb {
    fun detonate() {
        println("Bomb blast")
    }

    fun defuse() {
        println("Bomb defused")
    }
}