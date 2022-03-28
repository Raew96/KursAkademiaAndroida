package com.example.kursakademiaandroida.features.locations.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kursakademiaandroida.features.locations.domain.model.Location

@Entity(tableName = "location_cached")
data class LocationCached(
    @PrimaryKey
    val id: Int,
    val dimension: String,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) {

    constructor(location: Location) : this(
        id = location.id,
        dimension = location.dimension,
        name = location.name,
        residents = location.residents,
        type = location.type,
        url = location.url
    )

    companion object

    fun toLocation() = Location(
        id = id,
        dimension = dimension,
        name = name,
        residents = residents,
        type = type,
        url = url
    )

}