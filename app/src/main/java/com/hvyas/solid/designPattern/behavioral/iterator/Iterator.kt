package com.hvyas.solid.designPattern.behavioral.iterator

data class Book(val title: String, val author: String)

interface Iterator {
    val itemList: List<Any>
    var index: Int
    fun hasNext(): Boolean
    fun next(): Any?
}

class BookIterator(override val itemList: List<Book>) : Iterator {
    override var index: Int = 0

    override fun hasNext(): Boolean = index < itemList.size

    override fun next(): Book? {
        if (hasNext()) {
            return itemList[index++]
        }
        return null
    }
}

interface Aggregate {
    fun getIterator(): Iterator
}

class BookList() : Aggregate {
    override fun getIterator() = BookIterator(listOf())
}

fun main() {
    val bookList = BookList()
    val bookItr = bookList.getIterator()
    while (bookItr.hasNext()) {
        println(bookItr.next())
    }
}