package com.example.kursakademiaandroida.features.episodes.data.repository

import com.example.kursakademiaandroida.core.api.RickAndMortyApi
import com.example.kursakademiaandroida.core.api.model.EpisodesResponse
import com.example.kursakademiaandroida.core.network.NetworkStateProvider
import com.example.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import com.example.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.example.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.example.kursakademiaandroida.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class EpisodeRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN episodes request THEN fetch episodes from API`() {
        val api = mockk<RickAndMortyApi> {
            coEvery { getEpisodes() } returns EpisodesResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        //when
        runBlocking { repository.getEpisodes() }

        //then
        coVerify { api.getEpisodes() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN episodes request THEN save episodes to local database`() {
        val api = mockk<RickAndMortyApi> {
            coEvery { getEpisodes() } returns EpisodesResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        //when
        runBlocking { repository.getEpisodes() }

        //then
        coVerify { episodeDao.saveEpisodes(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN episodes request THEN fetch episodes from local database`() {
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val episodeDao = mockk<EpisodeDao> {
            coEvery { getEpisodes() } returns listOf(EpisodeCached.mock(), EpisodeCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        //when
        runBlocking { repository.getEpisodes() }

        //then
        coVerify { episodeDao.getEpisodes() }
    }

}
