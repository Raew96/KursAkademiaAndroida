package com.example.kursakademiaandroida.features.characters.presentation.model

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
) {
    constructor(characterOrigin: CharacterOrigin) : this(
        name = characterOrigin.name,
        url = characterOrigin.url
    )
}

data class CharacterLocation(
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )
}