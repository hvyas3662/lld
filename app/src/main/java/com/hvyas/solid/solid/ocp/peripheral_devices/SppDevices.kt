package com.hvyas.solid.solid.ocp.peripheral_devices

import com.hvyas.solid.solid.ocp.shape.Square

class SppDevices:Device<Square> {
    val sppDevices: Square = Square(23.40)

    override fun startDeviceSearch(onDisCover: (Square) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun stopDeviceSearch() {
        TODO("Not yet implemented")
    }

    override fun connectToDevice(device: Square) {
        TODO("Not yet implemented")
    }

    override fun disconnectToDevice() {
        TODO("Not yet implemented")
    }

    override fun readValue(): String {
        return super.readValue()
    }
}