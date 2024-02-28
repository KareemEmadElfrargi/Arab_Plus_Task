package com.example.arabplustask.feature.data.data_source.remote

import com.example.arabplustask.feature.domain.entity.RemoteCompetitions
import com.example.arabplustask.util.Resource

interface ICompetitionRemoteData {
    suspend fun getCompetition():Resource<RemoteCompetitions>
}