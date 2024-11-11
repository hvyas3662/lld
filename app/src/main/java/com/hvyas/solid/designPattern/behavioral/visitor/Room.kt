package com.hvyas.solid.designPattern.behavioral.visitor

//extracting method form class and creating classes for operation name main class As element and operation class as visitor
// for main class we divide it using interface for sub type
interface RoomElement {
    fun accept(roomVisitor: RoomVisitor)
}

class SingleBedRoom : RoomElement {
    override fun accept(roomVisitor: RoomVisitor) {
        roomVisitor.visit(this)
    }
}

class DoubleBedRoom : RoomElement {
    override fun accept(roomVisitor: RoomVisitor) {
        roomVisitor.visit(this)
    }
}

class DeluxeRoom : RoomElement {
    override fun accept(roomVisitor: RoomVisitor) {
        roomVisitor.visit(this)
    }
}

class SuperDeluxeRoom : RoomElement {
    override fun accept(roomVisitor: RoomVisitor) {
        roomVisitor.visit(this)
    }
}

interface RoomVisitor {
    fun visit(singleBedRoom: SingleBedRoom)
    fun visit(doubleBedRoom: DoubleBedRoom)
    fun visit(deluxeRoom: DeluxeRoom)
    fun visit(superDeluxeRoom: SuperDeluxeRoom)
}

class Prising : RoomVisitor {
    override fun visit(singleBedRoom: SingleBedRoom) {
        TODO("Not yet implemented")
    }

    override fun visit(doubleBedRoom: DoubleBedRoom) {
        TODO("Not yet implemented")
    }

    override fun visit(deluxeRoom: DeluxeRoom) {
        TODO("Not yet implemented")
    }

    override fun visit(superDeluxeRoom: SuperDeluxeRoom) {
        TODO("Not yet implemented")
    }

}

class Maintenance : RoomVisitor {
    override fun visit(singleBedRoom: SingleBedRoom) {
        TODO("Not yet implemented")
    }

    override fun visit(doubleBedRoom: DoubleBedRoom) {
        TODO("Not yet implemented")
    }

    override fun visit(deluxeRoom: DeluxeRoom) {
        TODO("Not yet implemented")
    }

    override fun visit(superDeluxeRoom: SuperDeluxeRoom) {
        TODO("Not yet implemented")
    }
}

fun main() {

    //concrete Class
    val singleBedRoom = SingleBedRoom()
    val doubleBedRoom = DoubleBedRoom()
    val deluxeRoom = DeluxeRoom()

    // OPERATION CLASS
    val prising = Prising()
    val maintenance = Maintenance()

    singleBedRoom.accept(prising)
    deluxeRoom.accept(maintenance)

    maintenance.visit(deluxeRoom)

}