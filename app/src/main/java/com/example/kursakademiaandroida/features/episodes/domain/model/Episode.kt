package com.example.kursakademiaandroida.features.episodes.domain.model

data class Episode(
    val id: Int,
    val airDate: String,
    val characters: List<Any>,
    val code: String,
    val name: String,
    val url: String
)