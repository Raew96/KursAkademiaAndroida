package com.example.kursakademiaandroida.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kursakademiaandroida.features.characters.domain.model.Character

@Entity(tableName = "character_cached")
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val episode: List<String>,
    val gender: String,
    val image: String,
    @Embedded(prefix = "CharacterLocationCached")
    val location: CharacterLocationCached,
    val name: String,
    @Embedded(prefix = "CharacterOriginCached")
    val origin: CharacterOriginCached,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {

    constructor(character: Character) : this(
        id = character.id,
        episode = character.episode,
        gender = character.gender,
        image = character.image,
        location = CharacterLocationCached(character.location),
        name = character.name,
        origin = CharacterOriginCached(character.origin),
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )

    companion object

    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin.toCharacterOrigin(),
        location = location.toCharacterLocation(),
        image = image,
        episode = episode,
        url = url
    )

    data class CharacterOriginCached(
        val name: String,
        val url: String
    ) {
        constructor(characterOrigin: Character.CharacterOrigin) : this(
            name = characterOrigin.name,
            url = characterOrigin.url
        )

        fun toCharacterOrigin() = Character.CharacterOrigin(
            name = name,
            url = url
        )
    }

    data class CharacterLocationCached(
        val name: String,
        val url: String
    ) {
        constructor(characterLocation: Character.CharacterLocation) : this(
            name = characterLocation.name,
            url = characterLocation.url
        )

        fun toCharacterLocation() = Character.CharacterLocation(
            name = name,
            url = url
        )
    }
}