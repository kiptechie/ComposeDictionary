package com.kiptechie.composedictionary.feature_dictionary.presentation

import com.kiptechie.composedictionary.feature_dictionary.domain.models.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
