package com.hvyas.solid.designPattern.structural.decorator_pattern

interface Developer {
    val experience: Int
    fun getCtc(): Long
}

class MobileDeveloper(override val experience: Int) : Developer {
    override fun getCtc() = experience * 300000L
}

class BackendDeveloper(override val experience: Int) : Developer {
    override fun getCtc() = experience * 400000L
}

class FrontendDeveloper(override val experience: Int) : Developer {
    override fun getCtc() = experience * 250000L
}

abstract class Skill(protected val developer: Developer) : Developer {
    override val experience: Int = developer.experience
}

class Oops(developer: Developer) : Skill(developer) {
    override fun getCtc(): Long = developer.getCtc() + 100000
}

class LLD(developer: Developer) : Skill(developer) {
    override fun getCtc(): Long = developer.getCtc() + 200000
}

class Db(developer: Developer) : Skill(developer) {
    override fun getCtc(): Long = developer.getCtc() + 300000
}

class CleanCode(developer: Developer) : Skill(developer) {
    override fun getCtc(): Long = developer.getCtc() + 400000
}

abstract class Bonus(protected val developer: Developer) : Developer {
    override val experience: Int = developer.experience
}

class EarlyJoiningBonus(developer: Developer, private val amount: Long) : Bonus(developer) {
    override fun getCtc(): Long = developer.getCtc() + amount
}

class DiwaliBonus(developer: Developer, private val amount: Long) : Bonus(developer) {
    override fun getCtc(): Long = developer.getCtc() + amount
}

class PerformanceBonus(developer: Developer, private val amount: Long) : Bonus(developer) {
    override fun getCtc(): Long = developer.getCtc() + amount
}

fun main() {
    val developer = PerformanceBonus(EarlyJoiningBonus(Db(LLD(Oops(MobileDeveloper(7)))), 200000), 500000)
    println(developer.getCtc())
}