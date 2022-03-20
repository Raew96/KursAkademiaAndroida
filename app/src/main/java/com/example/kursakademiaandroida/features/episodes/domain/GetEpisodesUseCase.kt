package com.example.kursakademiaandroida.features.episodes.domain

import com.example.kursakademiaandroida.core.base.UseCase
import com.example.kursakademiaandroida.features.episodes.EpisodeRepository
import com.example.kursakademiaandroida.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {
    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()
}