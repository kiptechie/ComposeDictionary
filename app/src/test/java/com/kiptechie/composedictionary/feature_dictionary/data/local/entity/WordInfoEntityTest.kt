package com.kiptechie.composedictionary.feature_dictionary.data.local.entity

import org.junit.Assert.*

import org.junit.Test

class WordInfoEntityTest {

    @Test
    fun `toWordInfo conversion works`() {
        val wordInfoEntity = WordInfoEntity(
            word = "word", phonetic = "null", origin = "null", meanings = listOf(), id = null,
            )
        val wordInfo = wordInfoEntity.toWordInfo()
        assertEquals(wordInfo.word, wordInfoEntity.word)
        assertEquals(wordInfo.phonetic, wordInfoEntity.phonetic)
        assertEquals(wordInfo.origin, wordInfoEntity.origin)
        assertEquals(wordInfo.meanings, wordInfoEntity.meanings)
        assertEquals(wordInfoEntity.id, null)
    }

}