package com.kiptechie.composedictionary.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kiptechie.composedictionary.feature_dictionary.domain.models.Meaning
import com.kiptechie.composedictionary.feature_dictionary.domain.models.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String?,
    val origin: String?,
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            word = word,
            phonetic = phonetic ?: "No Phonetic",
            origin = origin ?: "No Origin",
            meanings = meanings
        )
    }
}
