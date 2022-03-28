package com.example.kursakademiaandroida.features.episodes.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM episode_cached")
    suspend fun getEpisodes(): List<EpisodeCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEpisodes(vararg episode: EpisodeCached)

}