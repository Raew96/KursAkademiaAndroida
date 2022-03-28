package com.example.kursakademiaandroida.features.episodes.data.repository

import com.example.kursakademiaandroida.core.api.RickAndMortyApi
import com.example.kursakademiaandroida.core.network.NetworkStateProvider
import com.example.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import com.example.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.example.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.example.kursakademiaandroida.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val api: RickAndMortyApi,
    private val dao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getEpisodesFromRemote().also { saveEpisodesToLocal(it) }
        } else {
            getEpisodesFromLocal()
        }
    }

    private suspend fun getEpisodesFromRemote(): List<Episode> {
        return api.getEpisodes().results.map { it.toEpisode() }
    }

    private suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { dao.saveEpisodes(*it) }
    }

    private suspend fun getEpisodesFromLocal(): List<Episode> {
        return dao.getEpisodes().map { it.toEpisode() }
    }

}