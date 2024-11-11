package com.hvyas.solid.designPattern.behavioral.memento

class BoxConfigOriginator(var width: Int, var height: Int) {

    fun createMemento(): BoxConfigMemento = BoxConfigMemento(width, height)

    fun restoreMemento(memento: BoxConfigMemento) {
        width = memento.width
        height = memento.height
    }
}

//originator ke state variable ka data class
data class BoxConfigMemento(var width: Int, var height: Int)

class BoxConfigCaretaker() {
    private val history = mutableListOf<BoxConfigMemento>()

    fun addMemento(boxConfigMemento: BoxConfigMemento) {
        history.add(boxConfigMemento)
    }

    fun undo(): BoxConfigMemento? {
        if (history.isNotEmpty()) {
            val lastMemento = history.last()
            history.remove(lastMemento)
            return lastMemento
        }
        return null
    }
}

fun main() {
    val boxConfigCaretaker = BoxConfigCaretaker()
    val boxConfigOriginator = BoxConfigOriginator(10, 20)
    boxConfigCaretaker.addMemento(boxConfigOriginator.createMemento())

    boxConfigOriginator.apply {
        width = 30
        height = 30
    }

    boxConfigCaretaker.addMemento(boxConfigOriginator.createMemento())

    boxConfigOriginator.apply {
        width = 40
        height = 40
    }

    boxConfigCaretaker.addMemento(boxConfigOriginator.createMemento())

    boxConfigCaretaker.undo()?.let {
        boxConfigOriginator.restoreMemento(it)
    }
     boxConfigCaretaker.undo()?.let {
        boxConfigOriginator.restoreMemento(it)
    }

    println("boxConfigOriginator.width:  ${ boxConfigOriginator.width } boxConfigOriginator.height:  ${ boxConfigOriginator.height }")
}