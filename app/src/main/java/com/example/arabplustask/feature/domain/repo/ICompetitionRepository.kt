package com.example.arabplustask.feature.domain.repo

import com.example.arabplustask.feature.domain.entity.LocalCompetition
import com.example.arabplustask.feature.domain.entity.LocalCompetitions
import com.example.arabplustask.feature.domain.entity.RemoteCompetitions
import com.example.arabplustask.util.Resource

interface ICompetitionRepository {
    suspend fun getCompetition(): Resource<RemoteCompetitions>
    suspend fun getFromLocal(): LocalCompetitions
    suspend fun getFromRemote(): Resource<RemoteCompetitions>
    suspend fun saveToLocal(data :List<LocalCompetition>)
}