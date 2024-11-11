package com.hvyas.solid.designPattern.creational

import com.hvyas.solid.designPattern.creational.builder.Computer
import com.hvyas.solid.designPattern.creational.factory.lyrics.LyricsFactory
import com.hvyas.solid.designPattern.creational.factory_method.notification.EmailNotification
import com.hvyas.solid.designPattern.creational.factory_method.notification.EmailNotificationFactory
import com.hvyas.solid.designPattern.creational.factory_method.notification.SmsNotification
import com.hvyas.solid.designPattern.creational.factory_method.notification.SmsNotificationFactory
import com.hvyas.solid.designPattern.creational.factory.shap.Shape
import com.hvyas.solid.designPattern.creational.factory.shap.ShapeFactory
import com.hvyas.solid.designPattern.creational.prototype.Student
import com.hvyas.solid.designPattern.creational.singleton.SingletonPattern

class Uses {

    fun main() {
        val singletonPattern: SingletonPattern = SingletonPattern.getInstance()

        //factory pattern style1
        val smsNotification: SmsNotification = SmsNotificationFactory().create()
        smsNotification.notify("Email send")

        val emailNotification: EmailNotification = EmailNotificationFactory().create()
        emailNotification.notify("sms send")

        //factory pattern style2
        val circle: Shape = ShapeFactory().create("circle")
        val triangle: Shape = ShapeFactory().create("triangle")
        val square: Shape = ShapeFactory().create("square")

        //Builder pattern
        val computer = Computer.Builder()
            .cpu("Intel Core i7")
            .ram("16GB")
            .storage("512GB SSD")
            .gpu("NVIDIA GTX 1650")
            .powerSupply("650W")
            .build()
        computer.printDetails()

        val lyricsString = "a song lyrics"
        val lyrics = LyricsFactory().create(lyricsString)
        if (lyrics.isSynced) {
            lyrics.getSyncedLyrics()
        } else {
            lyrics.getLyricsString()
        }
        val student = Student("Hv", 10, "13EVGCS007")
        val student2 = student.copy(name = "HV2")
    }
}