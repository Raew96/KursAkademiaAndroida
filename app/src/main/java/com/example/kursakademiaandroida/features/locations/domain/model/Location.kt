package com.example.kursakademiaandroida.features.locations.domain.model

data class Location(
    val id: Int,
    val dimension: String,
    val name: String,
    val residents: List<Any>,
    val type: String,
    val url: String
)