package com.example.kursakademiaandroida.features.characters.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kursakademiaandroida.features.characters.data.local.model.CharacterCached

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character_cached ")
    suspend fun getCharacters(): List<CharacterCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(vararg episode: CharacterCached)

}