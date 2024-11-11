package com.hvyas.solid.solid.ocp.payment

import com.hvyas.solid.solid.srp.oms.Order

class PayPalPaymentMethod: PaymentMethod {

    override fun processPayment(order: Order): Boolean {
        println("Processing pay pal payment for order ${order.orderId}")
        return true
    }
}