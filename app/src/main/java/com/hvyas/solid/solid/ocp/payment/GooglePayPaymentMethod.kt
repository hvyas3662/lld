package com.hvyas.solid.solid.ocp.payment

import com.hvyas.solid.solid.srp.oms.Order

class GooglePayPaymentMethod: PaymentMethod {

    override fun processPayment(order: Order): Boolean {
        println("Processing google pay payment for order ${order.orderId}")
        return true
    }
}