package com.hvyas.solid.solid.srp.book

data class Book(var title:String, var author:String, val content:String){

    private val characterPerPage = 3000

    fun getPageCount() = content.length / characterPerPage
}