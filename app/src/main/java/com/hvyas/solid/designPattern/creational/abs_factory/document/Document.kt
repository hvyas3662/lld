package com.hvyas.solid.designPattern.creational.abs_factory.document

interface Element {
    fun render(): String
}

abstract class ParagraphFactory(protected val text: String) : Element

abstract class HeadingFactory(protected val text: String, protected val size: Int) : Element {
    init {
        require(size in 1..6) { "Size must be between 1 to 6" }
    }
}

abstract class LinkFactory(protected val text: String, protected val url: String) : Element {
    init {
        require(url.contains("http", ignoreCase = true)) { "Enter valid url" }
    }
}

interface ElementFactory {
    fun createParagraph(text: String): ParagraphFactory
    fun createHeading(text: String, size: Int): HeadingFactory
    fun createLink(text: String, url: String): LinkFactory
}

object HTMLElementFactory : ElementFactory {
    override fun createParagraph(text: String) = HtmlParagraphFactory(text)
    override fun createHeading(text: String, size: Int) = HtmlHeadingFactory(text, size)
    override fun createLink(text: String, url: String): LinkFactory = HtmlLinkFactory(text, url)
}

object MarkupElementFactory : ElementFactory {
    override fun createParagraph(text: String) = MarkupParagraphFactory(text)
    override fun createHeading(text: String, size: Int) = MarkupHeadingFactory(text, size)
    override fun createLink(text: String, url: String): LinkFactory = MarkupLinkFactory(text, url)
}

object JsonFactory : ElementFactory {
    override fun createParagraph(text: String) = JsonParagraphFactory(text)
    override fun createHeading(text: String, size: Int) = JsonHeadingFactory(text, size)
    override fun createLink(text: String, url: String): LinkFactory = JsonLinkFactory(text, url)
}

// Html Factory products
class HtmlParagraphFactory(text: String) : ParagraphFactory(text) {
    override fun render() = "<p>$text</p>"
}

class HtmlHeadingFactory(text: String, size: Int) : HeadingFactory(text, size) {
    override fun render() = "<h$size>$text</h$size>"
}

class HtmlLinkFactory(text: String, url: String) : LinkFactory(text, url) {
    override fun render() = "<a href=\"$url\">$text</a>"
}

// mark Up Factory products
class MarkupParagraphFactory(text: String) : ParagraphFactory(text) {
    override fun render() = text
}

class MarkupHeadingFactory(text: String, size: Int) : HeadingFactory(text, size) {
    override fun render() = "#".repeat(size) + text
}

class MarkupLinkFactory(text: String, url: String) : LinkFactory(text, url) {
    override fun render() = "$text($url)"
}


class JsonParagraphFactory(text: String) : ParagraphFactory(text) {
    override fun render() = "{\"$text\"}"
}

class JsonHeadingFactory(text: String, size: Int) : HeadingFactory(text, size) {
    override fun render() = "{\"text\":\"$text\", \"size\":\"$size\"}"
}

class JsonLinkFactory(text: String, url: String) : LinkFactory(text, url) {
    override fun render() = "{\"text\":\"$text\", \"url\":\"$url\"}"
}


class Document(private val factory: ElementFactory) {
    private val elementList = mutableListOf<Element>()

    fun addParagraph(text: String) = elementList.add(factory.createParagraph(text))
    fun addHeading(text: String, size: Int) = elementList.add(factory.createHeading(text, size))
    fun addLink(text: String, url: String) = elementList.add(factory.createLink(text, url))

    fun render(): String = elementList.joinToString("\n") { it.render() }
}