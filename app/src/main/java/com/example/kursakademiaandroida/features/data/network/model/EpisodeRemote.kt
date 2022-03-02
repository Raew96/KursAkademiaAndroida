package com.example.kursakademiaandroida.features.data.network.model

import com.example.kursakademiaandroida.features.episodes.domain.model.Episode
import com.google.gson.annotations.SerializedName


data class EpisodeRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("air_date") val airDate: String,
    @SerializedName("characters") val characters: List<String>,
    @SerializedName("created") val created: String,
    @SerializedName("episode") val code: String,
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toEpisode() = Episode(
        id = id,
        airDate = airDate,
        characters = characters,
        code = code,
        name = name,
        url = url
    )
}