package com.hvyas.solid.designPattern.creational.factory.lyrics

class LyricsFactory {
    fun create(lyrics: String): Lyrics {
        return if (isLyricsSynced(lyrics)) {
            SyncedLyrics(lyrics)
        } else {
            SimpleLyrics(lyrics)
        }
    }

    private fun isLyricsSynced(lyrics: String): Boolean = true
}