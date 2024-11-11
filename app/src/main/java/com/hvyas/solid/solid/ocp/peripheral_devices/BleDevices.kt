package com.hvyas.solid.solid.ocp.peripheral_devices

import com.hvyas.solid.solid.ocp.shape.Circle

class BleDevices:Device<Circle> {
    override fun startDeviceSearch(onDisCover: (Circle) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun stopDeviceSearch() {
        TODO("Not yet implemented")
    }

    override fun disconnectToDevice() {
        TODO("Not yet implemented")
    }

    override fun connectToDevice(device: Circle) {
        TODO("Not yet implemented")
    }

    override fun readValue(): String {
        return super.readValue()
    }

}