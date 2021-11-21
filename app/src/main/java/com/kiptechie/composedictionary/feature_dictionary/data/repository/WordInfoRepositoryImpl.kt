package com.kiptechie.composedictionary.feature_dictionary.data.repository

import com.kiptechie.composedictionary.core.util.Resource
import com.kiptechie.composedictionary.feature_dictionary.data.local.WordInfoDao
import com.kiptechie.composedictionary.feature_dictionary.data.remote.DictionaryApi
import com.kiptechie.composedictionary.feature_dictionary.domain.models.WordInfo
import com.kiptechie.composedictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfos(word = word).map { it.toWordInfo() }
        // still loading but we have some data to show
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfos = api.getWordInfo(word = word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word })
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",
                    data = wordInfos
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection.",
                    data = wordInfos
                )
            )
        }

        val newWordInfos = dao.getWordInfos(word = word).map {
            it.toWordInfo()
        }
        emit(Resource.Success(data = newWordInfos))
    }

}