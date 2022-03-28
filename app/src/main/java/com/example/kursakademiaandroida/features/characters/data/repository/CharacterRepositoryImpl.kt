package com.example.kursakademiaandroida.features.characters.data.repository

import com.example.kursakademiaandroida.core.api.RickAndMortyApi
import com.example.kursakademiaandroida.core.network.NetworkStateProvider
import com.example.kursakademiaandroida.features.characters.data.local.CharacterDao
import com.example.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.example.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.example.kursakademiaandroida.features.characters.domain.model.Character

class CharacterRepositoryImpl(
    private val api: RickAndMortyApi,
    private val dao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getCharactersFromRemote().also { saveCharactersToLocal(it) }
        } else {
            getCharactersFromLocal()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return api.getCharacters().results.map { it.toCharacter() }
    }

    private suspend fun saveCharactersToLocal(episodes: List<Character>) {
        episodes.map { CharacterCached(it) }
            .toTypedArray()
            .let { dao.saveCharacters(*it) }
    }

    private suspend fun getCharactersFromLocal(): List<Character> {
        return dao.getCharacters().map { it.toCharacter() }
    }

}