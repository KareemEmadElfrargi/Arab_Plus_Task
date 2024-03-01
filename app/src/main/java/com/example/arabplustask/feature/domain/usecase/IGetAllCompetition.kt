package com.example.arabplustask.feature.domain.usecase

import android.content.Context
import com.example.arabplustask.feature.domain.entity.DomainCompetitions
import com.example.arabplustask.feature.domain.entity.RemoteCompetition
import com.example.arabplustask.feature.domain.entity.RemoteCompetitions
import com.example.arabplustask.util.Resource

interface IGetAllCompetition {
    suspend fun getAllCompetitions(context: Context): Resource<DomainCompetitions>
}