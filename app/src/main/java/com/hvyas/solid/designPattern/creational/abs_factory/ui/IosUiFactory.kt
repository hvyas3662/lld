package com.hvyas.solid.designPattern.creational.abs_factory.ui

class IosUiFactory : UIFactory {
    override fun createButton(): Button {
        return IosButton()
    }

    override fun createTextField(): TextField {
        return IosTextField()
    }
}