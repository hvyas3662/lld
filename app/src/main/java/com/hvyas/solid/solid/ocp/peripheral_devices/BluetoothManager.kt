package com.hvyas.solid.solid.ocp.peripheral_devices

class BluetoothManager<T>(private val device: Device<T>) {

    fun startDeviceSearch() {
        device.startDeviceSearch { }
    }

    fun stopDeviceSearch() {
        device.stopDeviceSearch()
    }

    fun connectToDevice(device: T) {
        this.device.connectToDevice(device)
    }

    fun disconnectToDevice() {
        device.disconnectToDevice()
    }

    fun readValue(): String = ""
}


fun main() {
    BluetoothManager(BleDevices())
    BluetoothManager(SppDevices())
}