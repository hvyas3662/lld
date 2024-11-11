package com.hvyas.solid.solid.ocp.payment

import com.hvyas.solid.solid.srp.oms.Order

class OrderPaymentProcessor(private val paymentMethod: PaymentMethod) {
    fun processPayment(order: Order, ): Boolean {
        return paymentMethod.processPayment(order)
    }
}
