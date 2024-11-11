package com.hvyas.solid.solid.ocp.payment

import com.hvyas.solid.solid.srp.oms.Order

class BitCoinPaymentMethod: PaymentMethod {

    override fun processPayment(order: Order): Boolean {
        println("Processing bitcoin payment for order ${order.orderId}")
        return true
    }
}