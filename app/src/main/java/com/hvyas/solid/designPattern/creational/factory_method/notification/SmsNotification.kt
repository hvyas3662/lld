package com.hvyas.solid.designPattern.creational.factory_method.notification

class SmsNotification: Notification {
    override fun notify(message: String): Boolean {
       return true
    }
}