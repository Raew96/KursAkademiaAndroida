package com.example.kursakademiaandroida.features.characters.domain.model

data class Character(
    val id: Int,
    val episode: List<Any>,
    val gender: String,
    val image: String,
    val location: CharacterLocation,
    val name: String,
    val origin: CharacterOrigin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class CharacterOrigin(
    val name: String,
    val url: String
)

data class CharacterLocation(
    val name: String,
    val url: String
)