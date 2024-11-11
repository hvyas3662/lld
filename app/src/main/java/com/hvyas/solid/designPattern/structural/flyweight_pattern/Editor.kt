package com.hvyas.solid.designPattern.structural.flyweight_pattern

interface Letter {
    fun display(row: Int, col: Int, color: Int, isBold: Boolean, isItalic: Boolean, isUnderLined: Boolean, size: Double)
}

class LetterImpl(value: String, font: String) : Letter {
    override fun display(row: Int, col: Int, color: Int, isBold: Boolean, isItalic: Boolean, isUnderLined: Boolean, size: Double) {
        TODO("Not yet implemented")
    }
}

object LetterFactory {
    private val letterMap = mutableMapOf<String, Letter>()

    fun getLetter(type: String, font: String): Letter {
        return letterMap.getOrPut(type) { LetterImpl(type, font) }
    }
}

fun main() {
    val hLetter = LetterFactory.getLetter("h", "roboto")
    val cHLetter = LetterFactory.getLetter("H", "roboto bold")
    val vLetter = LetterFactory.getLetter("v", "roboto")
    val cVLetter = LetterFactory.getLetter("V", "roboto bold")
}