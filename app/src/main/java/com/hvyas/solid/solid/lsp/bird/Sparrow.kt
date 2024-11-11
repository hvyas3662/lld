package com.hvyas.solid.solid.lsp.bird

class Sparrow: Bird(), Flyable {
    override fun fly() {
        println("Sparrow flying...")
    }

}