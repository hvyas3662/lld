package com.hvyas.solid.solid.srp.oms

import kotlin.random.Random


class OrderProcessor(item: List<CartItem>) {

    private val order = Order(Random.nextLong(), item)

    fun processOrder() {
        val total = order.cartItemList.sumOf { it.price * it.quantity }
        println("Total Price: $total")
    }

    fun changeDeliveryDate(deliveryDate: String) {
        order.deliveryDate = deliveryDate
        processOrder()
    }

    fun changePaymentStatus(paymentMode: PaymentMode) {
        order.paymentMode = paymentMode
        processOrder()
    }

    fun placeOrder() {
        OrderCreator().placeOrder(order)
    }
}