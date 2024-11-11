package com.hvyas.solid.designPattern.creational.factory.lyrics

class SyncedLyrics(private val lyrics: String) : Lyrics {
    override val isSynced: Boolean = true

    override fun getLyricsString(): String {
        //todo logic to remove time stamp and trim
        return lyrics.trim()
    }

    override fun getSyncedLyrics(): Map<Long, String> {
        //todo logic to device in
        return emptyMap()
    }
}