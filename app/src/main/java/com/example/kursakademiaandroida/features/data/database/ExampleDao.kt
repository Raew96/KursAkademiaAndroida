package com.example.kursakademiaandroida.features.data.database

import androidx.room.Dao
import androidx.room.Query
import com.example.kursakademiaandroida.features.data.entities.ExampleEntity

@Dao
interface ExampleDao {

    @Query("SELECT * FROM example_entity")
    fun getAll(): List<ExampleEntity>

}