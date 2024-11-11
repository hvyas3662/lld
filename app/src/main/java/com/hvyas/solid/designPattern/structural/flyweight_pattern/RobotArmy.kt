package com.hvyas.solid.designPattern.structural.flyweight_pattern

import android.graphics.Bitmap

interface Robot {
    fun render(x: Int, y: Int, size: Float)
}

//fly weight object
class Humanoid(val type: String, val image: Bitmap) : Robot {
    override fun render(x: Int, y: Int, size: Float) {
        TODO("Not yet implemented")
    }
}

class DogRobot(val type: String, val image: Bitmap) : Robot {
    override fun render(x: Int, y: Int, size: Float) {
        TODO("Not yet implemented")
    }
}

// catching factory
object RobotFactory {
    private val robotMap = mutableMapOf<String, Robot>()

    fun create(type: String): Robot? = if (robotMap.containsKey(type)) {
        robotMap[type]
    } else {
        if (type == "human") {
            val human = Humanoid(type, Bitmap.createBitmap(0, 0, Bitmap.Config.ARGB_8888))
            robotMap[type] = human
            human
        } else {
            val dog = DogRobot(type, Bitmap.createBitmap(0, 0, Bitmap.Config.ARGB_8888))
            robotMap[type] = dog
            dog
        }
    }
}


//client
fun main() {

    val h1 = RobotFactory.create("Human")?.render(1, 1, 1.0f)
    val h2 = RobotFactory.create("Human")?.render(1, 2, 2.0f)

}