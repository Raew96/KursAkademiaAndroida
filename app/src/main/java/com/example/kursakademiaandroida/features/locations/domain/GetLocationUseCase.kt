package com.example.kursakademiaandroida.features.locations.domain

import com.example.kursakademiaandroida.core.base.UseCase
import com.example.kursakademiaandroida.features.locations.domain.model.Location

class GetLocationUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {
    override suspend fun action(params: Unit) = locationRepository.getLocations()
}