package com.hvyas.solid.solid.srp.oms

class Notification {

    fun sendEmail(from:String, to:String, message:String) {
        println(message)
    }

    fun sendSms(countryCOde:String, mobileNo:String, message:String) {
        println(message)
    }
}