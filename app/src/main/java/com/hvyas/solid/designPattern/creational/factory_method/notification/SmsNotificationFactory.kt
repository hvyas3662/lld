package com.hvyas.solid.designPattern.creational.factory_method.notification

class SmsNotificationFactory : NotificationFactory {
    override fun create(): SmsNotification {
        return SmsNotification()
    }
}