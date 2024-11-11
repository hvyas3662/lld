package com.hvyas.solid.solid.srp.oms

class OrderCreator {
    fun placeOrder(order: Order) {
        OrderRepository().saveOrder(order)
        Notification().apply {
            sendEmail("store@gmailcom", "customer@gmail.com", "Order placed successfully")
            sendSms("91", "7727806779", "Order placed successfully")
        }
    }
}