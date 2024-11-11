package com.hvyas.solid.designPattern.structural.facade_pattern

class OrderSystem {
    fun placeOrder() {
        OrderFacade().placeOrder(121, "sms")
    }
}


//facade method
class OrderFacade {
    private val productDao = ProductDao()
    private val paymentProcessor = PaymentProcessor()
    private val invoice = Invoice()
    private val notification = Notification()

    fun placeOrder(productId: Int, notificationType: String) {
        productDao.getProductDetail(productId)
        paymentProcessor.makePayment()
        invoice.generateInvoice()
        if (notificationType == "sms") notification.sendSms() else notification.sendEmail()
    }
}

//sub system
class ProductDao() {
    fun getProductDetail(id: Int) {

    }
}

class PaymentProcessor() {
    fun makePayment() {

    }
}

class Invoice() {
    fun generateInvoice() {

    }
}

class Notification() {
    fun sendSms() {

    }

    fun sendEmail() {

    }
}