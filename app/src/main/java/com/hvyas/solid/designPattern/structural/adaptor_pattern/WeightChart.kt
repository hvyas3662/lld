package com.hvyas.solid.designPattern.structural.adaptor_pattern

interface PoundWeightChart {
    fun getWeightInPounds(age: Int): Double
}

//adapte / existing interface
class ChildWeightChart : PoundWeightChart {
    override fun getWeightInPounds(age: Int) = ((2 * age) + 8.0)
}

//client
fun main() {
    val age = 4
    val getChildWtInKg = WeightChartAdapterImpl().getWeightInKg(4)
}


//abstract adaptor
interface WeightChartAdapter {
    fun getWeightInKg(age: Int): Double
}

// concrete adapter
class WeightChartAdapterImpl : WeightChartAdapter {
    private val poundWeightChart: PoundWeightChart = ChildWeightChart()
    override fun getWeightInKg(age: Int) = poundWeightChart.getWeightInPounds(age) * 0.45
}



