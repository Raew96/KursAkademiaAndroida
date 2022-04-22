package com.example.kursakademiaandroida.core.api.model

import com.example.kursakademiaandroida.features.characters.domain.model.Character
import com.google.gson.annotations.SerializedName

data class CharacterRemote(
    @SerializedName("created") val created: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("location") val location: CharacterLocationRemote,
    @SerializedName("name") val name: String,
    @SerializedName("origin") val origin: CharacterOriginRemote,
    @SerializedName("species") val species: String,
    @SerializedName("status") val status: String,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {

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

    data class CharacterOriginRemote(
        @SerializedName("name") val name: String,
        @SerializedName("url") val url: String
    ) {
        fun toCharacterOrigin() = Character.CharacterOrigin(
            name = name,
            url = url
        )
    }

    data class CharacterLocationRemote(
        @SerializedName("name") val name: String,
        @SerializedName("url") val url: String
    ) {
        fun toCharacterLocation() = Character.CharacterLocation(
            name = name,
            url = url
        )
    }

}

