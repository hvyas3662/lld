package com.hvyas.solid.designPattern.structural.proxy_pattern

interface WebSite {
    fun visit(url: String)
}

class WebSiteImpl : WebSite {
    override fun visit(url: String) {
        println("Visiting: $url")
    }
}

class WebSiteProxy : WebSite {

    private val webSite = WebSiteImpl()
    private val blockedUrlList = buildList {
        add("www.Youtube.com")
        add("www.instagram.com")
        add("www.facebook.com")
    }

    override fun visit(url: String) {
        if (blockedUrlList.any { url.contains(it, ignoreCase = true) }) {
            println("This Url is blocked")
        } else {
            webSite.visit(url)
        }
    }

}

fun main() {
    val website = WebSiteProxy()
    website.visit("www.facebook.com")
}