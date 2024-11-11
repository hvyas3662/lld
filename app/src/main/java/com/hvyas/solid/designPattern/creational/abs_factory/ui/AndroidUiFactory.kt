package com.hvyas.solid.designPattern.creational.abs_factory.ui

class AndroidUiFactory : UIFactory {
    override fun createButton(): Button {
        return AndroidButton()
    }

    override fun createTextField(): TextField {
        return AndroidTextField()
    }
}