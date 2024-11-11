package com.hvyas.solid.solid.ocp.peripheral_devices

interface Device<T> {
    fun startDeviceSearch(onDisCover: (T) -> Unit)

    fun stopDeviceSearch()

    fun connectToDevice(device: T)

    fun disconnectToDevice()

    fun readValue():String = ""
}