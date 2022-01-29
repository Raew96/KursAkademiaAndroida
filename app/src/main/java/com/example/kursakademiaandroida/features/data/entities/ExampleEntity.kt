package com.example.kursakademiaandroida.features.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "example_entity")
data class ExampleEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "example_name") val name: String = ""
)
