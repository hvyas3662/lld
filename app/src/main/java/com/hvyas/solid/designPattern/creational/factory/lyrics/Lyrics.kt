package com.hvyas.solid.designPattern.creational.factory.lyrics

interface Lyrics {

    val isSynced:Boolean

    fun getLyricsString():String

    fun getSyncedLyrics():Map<Long, String>
}