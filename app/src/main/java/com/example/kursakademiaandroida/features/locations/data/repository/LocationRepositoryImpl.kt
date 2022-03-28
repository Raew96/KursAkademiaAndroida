package com.example.kursakademiaandroida.features.locations.data.repository

import com.example.kursakademiaandroida.core.api.RickAndMortyApi
import com.example.kursakademiaandroida.core.network.NetworkStateProvider
import com.example.kursakademiaandroida.features.locations.data.local.LocationDao
import com.example.kursakademiaandroida.features.locations.data.local.model.LocationCached
import com.example.kursakademiaandroida.features.locations.domain.LocationRepository
import com.example.kursakademiaandroida.features.locations.domain.model.Location

class LocationRepositoryImpl(
    private val api: RickAndMortyApi,
    private val dao: LocationDao,
    private val networkStateProvider: NetworkStateProvider
) : LocationRepository {

    override suspend fun getLocations(): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getLocationsFromRemote().also { saveLocationsToLocal(it) }
        } else {
            getLocationsFromLocal()
        }
    }

    private suspend fun getLocationsFromRemote(): List<Location> {
        return api.getLocations().results.map { it.toLocation() }
    }

    private suspend fun saveLocationsToLocal(episodes: List<Location>) {
        episodes.map { LocationCached(it) }
            .toTypedArray()
            .let { dao.saveLocations(*it) }
    }

    private suspend fun getLocationsFromLocal(): List<Location> {
        return dao.getLocations().map { it.toLocation() }
    }

}