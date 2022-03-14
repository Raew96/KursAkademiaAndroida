package com.example.kursakademiaandroida.features.characters

import com.example.kursakademiaandroida.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}