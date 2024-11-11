package com.hvyas.solid.solid.ocp.payment

import com.hvyas.solid.solid.srp.oms.Order

interface PaymentMethod {
    fun processPayment(order: Order):Boolean
}