package com.hvyas.solid.designPattern.creational.abs_factory.ui

interface UIFactory {
    fun createButton(): Button
    fun createTextField(): TextField
}