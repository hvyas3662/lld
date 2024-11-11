package com.hvyas.solid.designPattern.creational.factory.lyrics

class SimpleLyrics(private val lyrics: String) : Lyrics {
    override val isSynced: Boolean = false
    override fun getLyricsString(): String {
        //todo logic clean lyrics
        return lyrics
    }

    override fun getSyncedLyrics(): Map<Long, String> {
        return mutableMapOf<Long, String>().apply {
            put(0, lyrics)
        }
    }
}