package com.hvyas.solid.solid.lsp.bird

class Main {

    private fun makeFly(bird:Flyable){
        bird.fly()
    }

    fun main(){
        val sparrow = Sparrow()
        val penguin = Penguin()
        makeFly(sparrow)
    }
}