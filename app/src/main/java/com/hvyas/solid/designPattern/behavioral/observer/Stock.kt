package com.hvyas.solid.designPattern.behavioral.observer

interface StockObservable {
    val observerList: MutableList<StockObserver>
    var itemCount: Int
    fun add(stockObserver: StockObserver)
    fun remove(stockObserver: StockObserver)
    fun notifyObserver()
    fun setData(itemCount: Int)
    fun getData(): Int
}

class StockObservableImpl : StockObservable {
    override val observerList: MutableList<StockObserver> = mutableListOf()

    override var itemCount: Int = 0

    override fun add(stockObserver: StockObserver) {
        observerList.add(stockObserver)
    }

    override fun remove(stockObserver: StockObserver) {
        observerList.remove(stockObserver)
    }

    override fun notifyObserver() {
        observerList.forEach { it.onChange() }
    }

    override fun setData(itemCount: Int) {
        val lastItemCount = this.itemCount
        this.itemCount = itemCount
        if (lastItemCount == 0 && this.itemCount > 0) notifyObserver()
    }

    override fun getData() = itemCount
}

interface StockObserver {
    val stockObservable: StockObservable
    fun onChange()
}

class EmailObserver(override val stockObservable: StockObservable, private val email: String) : StockObserver {
    override fun onChange() {
        println("Send Email To: $email : ${stockObservable.getData()}")
    }
}

class SmsObserver(override val stockObservable: StockObservable, private val mobileNo: String) : StockObserver {
    override fun onChange() {
        println("Send Sms To: $mobileNo : ${stockObservable.getData()}")
    }
}

fun main() {
    val stockObservableImpl = StockObservableImpl()
    val emailObserver = EmailObserver(stockObservableImpl, "Hitesh.vyas3662@gmail.com")
    val smsObserver = SmsObserver(stockObservableImpl, "7727806779")

    stockObservableImpl.add(emailObserver)
    stockObservableImpl.add(smsObserver)
    stockObservableImpl.add(object : StockObserver {
        override val stockObservable: StockObservable
            get() = stockObservableImpl

        override fun onChange() {
            println("Custom observer : ${stockObservable.getData()}")
        }
    })

    stockObservableImpl.setData(24)
    stockObservableImpl.setData(0)
    stockObservableImpl.setData(30)
}