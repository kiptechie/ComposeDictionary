package com.kiptechie.composedictionary.feature_dictionary.domain.repository

import com.kiptechie.composedictionary.core.util.Resource
import com.kiptechie.composedictionary.feature_dictionary.domain.models.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}