package com.example.kursakademiaandroida.features.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kursakademiaandroida.features.data.entities.ExampleEntity

@Database(entities = [ExampleEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}