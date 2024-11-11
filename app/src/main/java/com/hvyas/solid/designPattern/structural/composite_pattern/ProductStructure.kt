package com.hvyas.solid.designPattern.structural.composite_pattern

interface ProductStructure {
    fun print(): String
}

class Product(private val productName: String) : ProductStructure {
    override fun print(): String = productName
}

class Category(private val categoryName: String) : ProductStructure {
    private val subList: MutableList<ProductStructure> = mutableListOf()

    fun addSubProductOrCategory(productStructure: ProductStructure) {
        subList.add(productStructure)
    }

    override fun print(): String = buildString {
        append(categoryName)
        append("\n")
        subList.forEachIndexed { index, it ->
            append("${it.print()}")
            if (index < subList.size - 1) append("\n")
        }
    }
}

fun main() {
    val goldJewellery = Category("Gold Jewellery").apply {
        addSubProductOrCategory(Category("Ring").apply {
            addSubProductOrCategory(Category("Woman Ring").apply {
                addSubProductOrCategory(Product("WR1"))
                addSubProductOrCategory(Product("WR2"))
                addSubProductOrCategory(Product("WR3"))
            })
            addSubProductOrCategory(Category("Man Ring").apply {
                addSubProductOrCategory(Product("MR1"))
                addSubProductOrCategory(Product("MR2"))
            })
        })
        addSubProductOrCategory(Category("NeckLess").apply {
            addSubProductOrCategory(Product("NS1"))
            addSubProductOrCategory(Product("NS2"))
            addSubProductOrCategory(Product("NS3"))
        })
        addSubProductOrCategory(Category("Bangle")).apply {
            addSubProductOrCategory(Product("B1"))
            addSubProductOrCategory(Product("B2"))
        }
    }

    println(goldJewellery.print())

}