package com.hvyas.solid.solid.ocp.payment

import com.hvyas.solid.solid.srp.oms.Order

class CreditCardPaymentMethod: PaymentMethod {

    override fun processPayment(order: Order): Boolean {
        println("Processing credit card payment for order ${order.orderId}")
        return true
    }
}