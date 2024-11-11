package com.hvyas.solid.designPattern.structural.bridge_pattern

import java.util.UUID

interface PaymentProcessor {
    fun makePayment(amount: Double): Boolean
}

class PayPal : PaymentProcessor {
    override fun makePayment(amount: Double): Boolean {
        println("$amount paid by Pay pal")
        return true
    }
}

class PayTm : PaymentProcessor {
    override fun makePayment(amount: Double): Boolean {
        println("$amount paid by PayTm")
        return true
    }
}


class RogerPay : PaymentProcessor {
    override fun makePayment(amount: Double): Boolean {
        println("$amount payment failed vy RogerPay")
        return true
    }
}

abstract class OrderProcessor(protected val paymentProcessor: PaymentProcessor) {
    abstract fun purchase(itemId: String, amount: Double): Boolean
}

class FlightTicketOrderProcessor(paymentProcessor: PaymentProcessor) : OrderProcessor(paymentProcessor) {
    override fun purchase(itemId: String, amount: Double): Boolean {
        println("save log in ticket table")
        val isPaymentSuccess = paymentProcessor.makePayment(amount)
        if (isPaymentSuccess) {
            // save booking detail
            //send ticket on mail
            //send check in detail
            //
        }
        return isPaymentSuccess
    }


}

class DigitalGoodsOrderProcessor(paymentProcessor: PaymentProcessor) : OrderProcessor(paymentProcessor) {
    override fun purchase(itemId: String, amount: Double): Boolean {
        println("save log in digital item table")
        val isPaymentSuccess = paymentProcessor.makePayment(amount)
        if (isPaymentSuccess) {
            // save booking detail
            //send ticket on mail
            //send check in detail
            //
        }
        return isPaymentSuccess
    }
}

class GoodsOrderProcessor(paymentProcessor: PaymentProcessor) : OrderProcessor(paymentProcessor) {
    override fun purchase(itemId: String, amount: Double): Boolean {
        println("save log in goods table")
        val isPaymentSuccess = paymentProcessor.makePayment(amount)
        if (isPaymentSuccess) {
            // save booking detail
            //send ticket on mail
            //send check in detail
            //
        }
        return isPaymentSuccess
    }
}

fun main() {
    GoodsOrderProcessor(RogerPay()).purchase(UUID.randomUUID().toString(), 56000.0)
}
