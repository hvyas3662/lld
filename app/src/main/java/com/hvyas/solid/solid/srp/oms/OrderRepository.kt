package com.hvyas.solid.solid.srp.oms

class OrderRepository {

    fun getAllOrderList():List<Order>{
        return emptyList()
    }

    fun getOrderById(orderId: Long):Order{
        return Order(orderId)
    }

    fun saveOrder(order: Order){
        println("Order saved successfully")
    }

}