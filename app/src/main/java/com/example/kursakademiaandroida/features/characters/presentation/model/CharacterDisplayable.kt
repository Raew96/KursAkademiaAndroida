package com.example.kursakademiaandroida.features.characters.presentation.model

import com.example.kursakademiaandroida.features.characters.domain.model.Character

data class CharacterDisplayable(
    val id: Int,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val location: CharacterLocationDisplayable,
    val name: String,
    val origin: CharacterOriginDisplayable,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    data class CharacterOriginDisplayable(
        val name: String,
        val url: String
    ) {
        constructor(characterOrigin: Character.CharacterOrigin) : this(
            name = characterOrigin.name,
            url = characterOrigin.url
        )
    }

    data class CharacterLocationDisplayable(
        val name: String,
        val url: String
    ) {
        constructor(characterLocation: Character.CharacterLocation) : this(
            name = characterLocation.name,
            url = characterLocation.url
        )
    }

    constructor(character: Character) : this(
        id = character.id,
        episode = character.episode,
        gender = character.gender,
        image = character.image,
        location = CharacterLocationDisplayable(character.location),
        name = character.name,
        origin = CharacterOriginDisplayable(character.origin),
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )
}
