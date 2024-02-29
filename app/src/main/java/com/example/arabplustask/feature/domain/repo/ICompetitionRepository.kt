package com.example.arabplustask.feature.domain.repo

import android.content.Context
import com.example.arabplustask.feature.domain.entity.DomainCompetitions
import com.example.arabplustask.feature.domain.entity.LocalCompetition
import com.example.arabplustask.feature.domain.entity.LocalCompetitions
import com.example.arabplustask.feature.domain.entity.RemoteCompetitions
import com.example.arabplustask.util.Resource

interface ICompetitionRepository {
    suspend fun getCompetition(context: Context): Resource<DomainCompetitions>
    suspend fun getFromLocal(): LocalCompetitions
    suspend fun getFromRemote(): Resource<RemoteCompetitions>
    suspend fun saveToLocal(data :List<LocalCompetition>)
}