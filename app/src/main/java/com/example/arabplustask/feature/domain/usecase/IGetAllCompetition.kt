package com.example.arabplustask.feature.domain.usecase

import com.example.arabplustask.feature.domain.entity.DomainCompetitions
import com.example.arabplustask.feature.domain.entity.RemoteCompetition
import com.example.arabplustask.feature.domain.entity.RemoteCompetitions
import com.example.arabplustask.util.Resource

interface IGetAllCompetition {
    suspend fun getAllCompetitions(): Resource<DomainCompetitions>
}