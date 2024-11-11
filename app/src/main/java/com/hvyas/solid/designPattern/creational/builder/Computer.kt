package com.hvyas.solid.designPattern.creational.builder

class Computer private constructor(
    val cpu: String = "Unknown",
    val gpu: String = "Unknown",
    val ram: String = "Unknown",
    val storage: String = "Unknown",
    val powerSupply: String = "Unknown"
) {

    fun printDetails() {
        println("Computer Configuration: CPU: $cpu, RAM: $ram, Storage: $storage, GPU: $gpu, Power Supply: $powerSupply")
    }

    class Builder {
        private var cpu: String = "Unknown"
        private var gpu: String = "Unknown"
        private var ram: String = "Unknown"
        private var storage: String = "Unknown"
        private var powerSupply: String = "Unknown"

        fun cpu(cpu: String): Builder {
            this.cpu = cpu
            return this
        }

        fun gpu(gpu: String) = apply { this.gpu = gpu }
        fun ram(ram: String) = apply { this.ram = ram }
        fun storage(storage: String) = apply { this.storage = storage }
        fun powerSupply(powerSupply: String) = apply { this.powerSupply = powerSupply }
        fun build() = Computer(cpu, gpu, ram, storage, powerSupply)
    }
}