package com.hvyas.solid.solid.srp.oms

import java.util.Date

data class Order(
    val orderId:Long,
    val cartItemList: List<CartItem> = mutableListOf(),
    val orderDate: Long = Date().time,
    var deliveryDate: String = "",
    var paymentMode: PaymentMode = PaymentMode.ONLINE
)