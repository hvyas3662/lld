package com.hvyas.solid.designPattern.creational.singleton
//The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance.
class SingletonPattern private constructor() {

    companion object {

        @JvmStatic
        private var instance: SingletonPattern? = null

        @JvmStatic
        fun getInstance(): SingletonPattern {
            if (instance == null) {
                synchronized(SingletonPattern::class.java){
                    if (instance == null)  instance = SingletonPattern()
                }
            }
            return instance!!
        }
    }
}