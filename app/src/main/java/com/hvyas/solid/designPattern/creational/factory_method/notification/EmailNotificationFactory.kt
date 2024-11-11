package com.hvyas.solid.designPattern.creational.factory_method.notification

class EmailNotificationFactory: NotificationFactory {
    override fun create(): EmailNotification {
         return EmailNotification()
    }
}