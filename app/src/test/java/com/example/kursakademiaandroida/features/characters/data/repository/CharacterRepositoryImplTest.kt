package com.example.kursakademiaandroida.features.characters.data.repository

import com.example.kursakademiaandroida.core.api.RickAndMortyApi
import com.example.kursakademiaandroida.core.api.model.CharactersResponse
import com.example.kursakademiaandroida.core.network.NetworkStateProvider
import com.example.kursakademiaandroida.features.characters.data.local.CharacterDao
import com.example.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.example.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.example.kursakademiaandroida.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class CharacterRepositoryImplTest {

    @Test
    fun `Given network is connected WHEN character request THEN fetch characters form API`() {
        val api = mockk<RickAndMortyApi> {
            coEvery { getCharacters() } returns CharactersResponse.mock()
        }
        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { api.getCharacters() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN character request THEN save characters to local database`() {
        val api = mockk<RickAndMortyApi> {
            coEvery { getCharacters() } returns CharactersResponse.mock()
        }
        val episodeDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, episodeDao, networkStateProvider)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { episodeDao.saveCharacters(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN character request THEN fetch characters from local database`() {
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val episodeDao = mockk<CharacterDao> {
            coEvery { getCharacters() } returns listOf(
                CharacterCached.mock(),
                CharacterCached.mock()
            )
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, episodeDao, networkStateProvider)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { episodeDao.getCharacters() }
    }
}