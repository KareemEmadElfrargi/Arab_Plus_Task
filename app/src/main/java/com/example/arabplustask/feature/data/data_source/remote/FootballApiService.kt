package com.example.arabplustask.feature.data.data_source.remote

import com.example.arabplustask.feature.domain.entity.RemoteCompetitions
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface FootballApiService {
    @GET("competitions/")
    suspend fun getCompetitions(@Header("Authorization") token: String): Response<RemoteCompetitions>
}