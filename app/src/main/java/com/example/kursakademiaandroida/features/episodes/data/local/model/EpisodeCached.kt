package com.example.kursakademiaandroida.features.episodes.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kursakademiaandroida.features.episodes.domain.model.Episode

@Entity(tableName = "episode_cached")
data class EpisodeCached(
    @PrimaryKey
    val id: Int,
    val airDate: String,
    val characters: List<String>,
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

    companion object

    fun toEpisode() = Episode(
        id = id,
        airDate = airDate,
        characters = characters,
        code = code,
        name = name,
        url = url
    )

}