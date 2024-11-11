package com.hvyas.solid.designPattern.structural.proxy_pattern

interface EditorElement {
    fun render(text: String)
}

class Paragraph : EditorElement {
    override fun render(text: String) {
        println("<p><$text</p>")
    }
}

class ListElement : EditorElement {
    override fun render(text: String) {
        println("<ul><li><$text</li></ul>")
    }
}

class ParagraphProxy : EditorElement {
    private val paragraph = Paragraph()
    private val list = ListElement()

    override fun render(text: String) {
        if (text.startsWith("1. ")) {
            list.render(text)
        } else {
            paragraph.render(text)
        }
    }

}