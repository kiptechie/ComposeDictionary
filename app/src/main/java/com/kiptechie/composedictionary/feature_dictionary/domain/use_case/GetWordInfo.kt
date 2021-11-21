package com.kiptechie.composedictionary.feature_dictionary.domain.use_case

import com.kiptechie.composedictionary.core.util.Resource
import com.kiptechie.composedictionary.feature_dictionary.domain.models.WordInfo
import com.kiptechie.composedictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow { }
        }
        return repository.getWordInfo(word = word)
    }

}