package com.hvyas.solid.designPattern.behavioral.chain_of_responsibility

//abs handler
abstract class MyLogger(private val nextLogger: MyLogger?) {

    open fun handleRequest(level: Int, message: String) {
        if (nextLogger != null) {
            nextLogger.handleRequest(level, message)
        } else {
            println("Unable to handle request")
        }
    }

    companion object {
        const val INFO = 1
        const val DEBUG = 2
        const val ERROR = 3
    }
}

//concrete handler
class InfoLogger(nextLogger: MyLogger?) : MyLogger(nextLogger) {
    override fun handleRequest(level: Int, message: String) {
        if (level == INFO) {
            println("I ${System.currentTimeMillis()}:\t$message")
        } else {
            super.handleRequest(level, message)
        }
    }
}

class DebugLogger(nextLogger: MyLogger?) : MyLogger(nextLogger) {
    override fun handleRequest(level: Int, message: String) {
        if (level == DEBUG) {
            println("D ${System.currentTimeMillis()}:\t$message")
        } else {
            super.handleRequest(level, message)
        }
    }
}

class ErrorLogger(nextLogger: MyLogger?) : MyLogger(nextLogger) {
    override fun handleRequest(level: Int, message: String) {
        if (level == ERROR) {
            println("E ${System.currentTimeMillis()}:\t$message")
        } else {
            super.handleRequest(level, message)
        }
    }
}


fun main() {
    val logger = InfoLogger(DebugLogger(ErrorLogger(null)))

    logger.handleRequest(MyLogger.ERROR, "Null pointer exception")
    logger.handleRequest(MyLogger.DEBUG, "this class called")
    logger.handleRequest(MyLogger.INFO, "val x= 24")
    logger.handleRequest(4, "Invalid log level")
}