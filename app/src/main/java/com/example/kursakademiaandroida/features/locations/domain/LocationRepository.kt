package com.example.kursakademiaandroida.features.locations.domain

import com.example.kursakademiaandroida.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}