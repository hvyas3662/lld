package com.hvyas.solid.designPattern.behavioral.mediator

class AuctionMediator(private var lastBid: Double) {

    private val bidderList = mutableListOf<IBidder>()
    private val lastBit = mutableListOf<IBidder>()

    fun addBidder(bidder: IBidder) {
        bidderList.add(bidder)
    }

    fun postBid(bidder: IBidder, amount: Double) {
        if (amount > lastBid) {
            lastBid = amount
            bidderList.forEach {
                if (it.name != bidder.name) it.onBidUpdated(lastBid)
            }
        }
    }
}

interface IBidder {
    val name: String
    val auctionMediator: AuctionMediator

    fun postBid(amount: Double)
    fun onBidUpdated(amount: Double)
}

class Bidder(override val name: String, override val auctionMediator: AuctionMediator) : IBidder {

    init {
        auctionMediator.addBidder(this)
    }

    override fun postBid(amount: Double) {
        auctionMediator.postBid(this, amount)
    }

    override fun onBidUpdated(amount: Double) {
        println("$name: New Bid: $amount")
    }
}

fun main() {
    val auctionMediator = AuctionMediator(1000.0)
    val bidder1 = Bidder("B1", auctionMediator)
    val bidder2 = Bidder("B2", auctionMediator)
    val bidder3 = Bidder("B3", auctionMediator)

    bidder1.postBid(1999.0)
    bidder3.postBid(3000.0)
    bidder2.postBid(4000.0)

}