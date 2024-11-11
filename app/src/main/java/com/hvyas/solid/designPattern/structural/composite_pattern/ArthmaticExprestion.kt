package com.hvyas.solid.designPattern.structural.composite_pattern

interface ArithmeticExpression {
    fun calculate(): Double
}

class Number(private val value: Double) : ArithmeticExpression {
    override fun calculate() = value
}

enum class Operation { ADD, SUBTRACT, MULTIPLY, DIVIDE }

class Expression(
    private val leftExpression: ArithmeticExpression,
    private val rightExpression: ArithmeticExpression,
    private val operation: Operation
) :
    ArithmeticExpression {
    override fun calculate(): Double = when (operation) {
        Operation.ADD -> leftExpression.calculate() + rightExpression.calculate()
        Operation.SUBTRACT -> leftExpression.calculate() - rightExpression.calculate()
        Operation.MULTIPLY -> leftExpression.calculate() * rightExpression.calculate()
        Operation.DIVIDE -> leftExpression.calculate() / rightExpression.calculate()
    }
}

fun main() {
    // 2*((5+7)/3)
    val two = Number(2.0)
    val three = Number(3.0)
    val five = Number(5.0)
    val seven = Number(7.0)

    val exp1 = Expression(five, seven, Operation.ADD)
    val exp2 = Expression(exp1, three, Operation.DIVIDE)
    val exp3 = Expression(two, exp2, Operation.MULTIPLY)
    val exp4 = Expression(exp3, three, Operation.SUBTRACT)

    println(exp4.calculate())
}