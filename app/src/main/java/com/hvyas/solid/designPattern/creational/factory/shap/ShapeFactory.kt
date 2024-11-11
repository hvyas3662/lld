package com.hvyas.solid.designPattern.creational.factory.shap

class ShapeFactory {
    fun create(whichShape: String) = when (whichShape.lowercase()) {
        "circle" -> Circle()
        "Square" -> Square()
        else -> Triangle()
    }
}