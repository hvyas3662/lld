package com.hvyas.solid.solid.srp.oms

class Cart {

    private val cartItemList = mutableListOf<CartItem>()
    fun addToCart(cartItem: CartItem) {
        cartItemList.add(cartItem)
    }

    fun removeToCart(itemId: Long) {
        cartItemList.removeIf { it.id == itemId }
    }

    fun updateItemDetail(itemId: Long, price: Double, quantity: Int) {
        cartItemList.find { it.id == itemId }?.let { item ->
            item.price = price;
            item.quantity = quantity;
        }
    }

    fun processOrder() {
        OrderProcessor(cartItemList).processOrder()
    }
}