package com.hvyas.solid.solid.dip.computer

class Mouse:InputDevice {
    override fun input(): String {
        return  "pointer location"
    }
}