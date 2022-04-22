package com.example.kursakademiaandroida.core.network

interface NetworkStateProvider {
    fun isNetworkAvailable(): Boolean
}