package com.hvyas.solid.solid.srp.book

class BookPrinter {

    fun printBook(book: Book):String {
        return buildString {
            append(book.title)
            append("\n")
            append(book.author)
            append("\n\n")
            append(book.content)
        }
    }
}