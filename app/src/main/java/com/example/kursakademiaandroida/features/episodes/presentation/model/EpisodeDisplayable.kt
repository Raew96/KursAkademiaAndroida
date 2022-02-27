package com.example.kursakademiaandroida.features.episodes.presentation.model

import com.example.kursakademiaandroida.features.episodes.domain.model.Episode

data class EpisodeDisplayable(
    val id: Int,
    val airDate: String,
    val characters: List<Any>,
    val code: String,
    val name: String,
    val url: String
) {
    constructor(episode: Episode) : this(
        id = episode.id,
        airDate = episode.airDate,
        characters = episode.characters,
        code = episode.code,
        name = episode.name,
        url = episode.url
    )
}