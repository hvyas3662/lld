package com.hvyas.solid.designPattern.behavioral.state

sealed class Item(val code: Int, val name: String, val price: Int) {
    class Coke(code: Int, name: String, price: Int) : Item(code, name, price)
    class Pepsi(code: Int, name: String, price: Int) : Item(code, name, price)
    class Soda(code: Int, name: String, price: Int) : Item(code, name, price)
    class Water(code: Int, name: String, price: Int) : Item(code, name, price)
}

data class Coin(val name: String, val value: Int)

class WendingMatching {
    val itemList: MutableList<Item> = mutableListOf()
    val coinList: MutableList<Coin> = mutableListOf()
    var state: State = Ideal()

    fun changeState(state: State) {
        this.state = state
    }

    fun start() = state.start(this)
    fun inputMoney(coin: Coin) = state.inputMoney(this, coin)
    fun selectItem(itemCode: Int) = state.selectItem(this, itemCode)
    fun refund() = state.refund(this)
    fun cancel() = state.cancel(this)
    fun dispatch() = state.dispatch(this)
    fun addItem() = state.addItem(this)
    fun addCoin(value: Int) = state.addCoin(this, value)
    fun removeCoin(totalInputAmount: Int) = state.removeCoin(this, totalInputAmount)
    fun startMaintenance() = state.startMaintenance(this)
    fun stopMaintenance() = state.stopMaintenance(this)
}

interface State {
    @Throws(RuntimeException::class)
    fun start(wendingMatching: WendingMatching)

    @Throws(RuntimeException::class)
    fun inputMoney(wendingMatching: WendingMatching, coin: Coin)

    @Throws(RuntimeException::class)
    fun selectItem(wendingMatching: WendingMatching, itemCode: Int)

    @Throws(RuntimeException::class)
    fun refund(wendingMatching: WendingMatching)

    @Throws(RuntimeException::class)
    fun cancel(wendingMatching: WendingMatching)

    @Throws(RuntimeException::class)
    fun dispatch(wendingMatching: WendingMatching)

    @Throws(RuntimeException::class)
    fun addItem(wendingMatching: WendingMatching)

    @Throws(RuntimeException::class)
    fun addCoin(wendingMatching: WendingMatching, value: Int)

    @Throws(RuntimeException::class)
    fun removeCoin(wendingMatching: WendingMatching, totalInputAmount: Int)

    @Throws(RuntimeException::class)
    fun startMaintenance(wendingMatching: WendingMatching)

    @Throws(RuntimeException::class)
    fun stopMaintenance(wendingMatching: WendingMatching)
}

class Ideal : State {
    init {
        println("**** Ideal State ****")
    }

    override fun start(wendingMatching: WendingMatching) {
        wendingMatching.changeState(ItemSelection())
    }

    override fun inputMoney(wendingMatching: WendingMatching, coin: Coin) {
        throw RuntimeException("funcanility not available")
    }

    override fun selectItem(wendingMatching: WendingMatching, itemCode: Int) {
        throw RuntimeException("funcanility not available")
    }

    override fun refund(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun cancel(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun dispatch(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun addItem(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun addCoin(wendingMatching: WendingMatching, value: Int) {
        throw RuntimeException("funcanility not available")
    }

    override fun removeCoin(wendingMatching: WendingMatching, totalInputAmount: Int) {
        throw RuntimeException("funcanility not available")
    }

    override fun startMaintenance(wendingMatching: WendingMatching) {
        wendingMatching.changeState(Maintenance())
    }

    override fun stopMaintenance(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }
}

class ItemSelection : State {
    init {
        println("**** Item Selection ****")
    }

    override fun start(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun inputMoney(wendingMatching: WendingMatching, coin: Coin) {
        throw RuntimeException("funcanility not available")
    }

    override fun selectItem(wendingMatching: WendingMatching, itemCode: Int) {
        val selectedItem = wendingMatching.itemList.find { it.code == itemCode }
        if (selectedItem != null) {
            println("${selectedItem.name} is selected")
            wendingMatching.changeState(InputMoney(selectedItem))
        } else {
            println("Item not found Canceling session")
            cancel(wendingMatching)
        }
    }

    override fun refund(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun cancel(wendingMatching: WendingMatching) {
        wendingMatching.changeState(Ideal())
    }

    override fun dispatch(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun addItem(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun addCoin(wendingMatching: WendingMatching, value: Int) {
        throw RuntimeException("funcanility not available")
    }

    override fun removeCoin(wendingMatching: WendingMatching, totalInputAmount: Int) {
        throw RuntimeException("funcanility not available")
    }


    override fun startMaintenance(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun stopMaintenance(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }
}

class InputMoney(private val selectedItem: Item) : State {
    private var totalInputAmount = 0

    init {
        println("**** Input money ****")
    }

    override fun start(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun inputMoney(wendingMatching: WendingMatching, coin: Coin) {
        totalInputAmount += coin.value
        addCoin(wendingMatching, coin.value)
        println("${coin.name} rs coin added")
        if (totalInputAmount >= selectedItem.price) {
            wendingMatching.changeState(Dispatch(selectedItem, totalInputAmount))
        }
    }

    override fun selectItem(wendingMatching: WendingMatching, itemCode: Int) {
        throw RuntimeException("funcanility not available")
    }

    override fun refund(wendingMatching: WendingMatching) {
        removeCoin(wendingMatching, totalInputAmount)
        println("Refund: $totalInputAmount")
    }

    override fun cancel(wendingMatching: WendingMatching) {
        refund(wendingMatching)
        wendingMatching.changeState(Ideal())
    }

    override fun dispatch(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun addItem(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun addCoin(wendingMatching: WendingMatching, value: Int) {
    }

    override fun removeCoin(wendingMatching: WendingMatching, totalInputAmount: Int) {
    }

    override fun startMaintenance(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun stopMaintenance(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }
}

class Dispatch(private val selectedItem: Item, private val totalInputAmount: Int) : State {
    private var remanningAmount = totalInputAmount

    init {
        println("**** Dispatch State ****")
    }

    override fun start(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun inputMoney(wendingMatching: WendingMatching, coin: Coin) {
        throw RuntimeException("funcanility not available")
    }

    override fun selectItem(wendingMatching: WendingMatching, itemCode: Int) {
        throw RuntimeException("funcanility not available")
    }

    override fun refund(wendingMatching: WendingMatching) {
        removeCoin(wendingMatching, remanningAmount)
        println("Refund: $remanningAmount")
    }

    override fun cancel(wendingMatching: WendingMatching) {
        refund(wendingMatching)
        wendingMatching.changeState(Ideal())
    }

    override fun dispatch(wendingMatching: WendingMatching) {
        remanningAmount = totalInputAmount- remanningAmount
        refund(wendingMatching)
        wendingMatching.itemList.remove(selectedItem)
        println("Dispatch Item: ${selectedItem.name} ")
        wendingMatching.changeState(Ideal())
    }

    override fun addItem(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun addCoin(wendingMatching: WendingMatching, value: Int) {
        throw RuntimeException("funcanility not available")
    }

    override fun removeCoin(wendingMatching: WendingMatching, totalInputAmount: Int) {
    }

    override fun startMaintenance(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun stopMaintenance(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }
}

class Maintenance : State {

    init {
        println("**** Maintenance State ****")
    }

    override fun start(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun inputMoney(wendingMatching: WendingMatching, coin: Coin) {
        throw RuntimeException("funcanility not available")
    }

    override fun selectItem(wendingMatching: WendingMatching, itemCode: Int) {
        throw RuntimeException("funcanility not available")
    }

    override fun refund(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun cancel(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun dispatch(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun addItem(wendingMatching: WendingMatching) {

    }

    override fun addCoin(wendingMatching: WendingMatching, value: Int) {

    }

    override fun removeCoin(wendingMatching: WendingMatching, value: Int) {

    }

    override fun startMaintenance(wendingMatching: WendingMatching) {
        throw RuntimeException("funcanility not available")
    }

    override fun stopMaintenance(wendingMatching: WendingMatching) {
        wendingMatching.changeState(Ideal())
    }
}

fun main() {

    WendingMatching().apply {
        itemList.apply {
            add(Item.Coke(1, "Coke", 25))
            add(Item.Pepsi(2, "Pepsi", 35))
            add(Item.Soda(3, "Soda", 20))
            add(Item.Water(4, "Water", 10))
        }
        val tenCoin = Coin("ten", 10)

        start()
        selectItem(2)
        inputMoney(tenCoin)
        inputMoney(tenCoin)
        inputMoney(tenCoin)
        inputMoney(tenCoin)
        dispatch()
        startMaintenance()
        addItem()
        removeCoin(200)
        addCoin(100)
        stopMaintenance()
    }
}
