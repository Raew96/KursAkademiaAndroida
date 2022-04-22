package com.example.kursakademiaandroida.mock

import com.example.kursakademiaandroida.core.api.model.*
import com.example.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.example.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.example.kursakademiaandroida.features.locations.data.local.model.LocationCached
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
    created = "example data"
)

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 1,
    name = "episode name",
    url = "episode url",
    created = "example data",
    episode = emptyList(),
    image = "",
    location = CharacterRemote.CharacterLocationRemote("", ""),
    origin = CharacterRemote.CharacterOriginRemote("", ""),
    species = "",
    status = "",
    type = "",
    gender = ""
)


@TestOnly
fun CharactersResponse.Companion.mock() = CharactersResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    name = "character name",
    url = "character url",
    episode = emptyList(),
    image = "",
    location = CharacterCached.CharacterLocationCached("", ""),
    origin = CharacterCached.CharacterOriginCached("", ""),
    species = "",
    status = "",
    type = "",
    gender = ""
)

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 1,
    name = "location name",
    url = "location url",
    created = "example data",
    dimension = "example dimension",
    residents = emptyList(),
    type = "example type"
)


@TestOnly
fun LocationsResponse.Companion.mock() = LocationsResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    name = "location name",
    url = "location url",
    dimension = "example dimension",
    residents = emptyList(),
    type = "example type"
)