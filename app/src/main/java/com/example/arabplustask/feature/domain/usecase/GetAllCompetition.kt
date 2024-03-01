package com.example.arabplustask.feature.domain.usecase

import android.content.Context
import com.example.arabplustask.feature.domain.entity.DomainCompetitions
import com.example.arabplustask.feature.domain.entity.RemoteCompetition
import com.example.arabplustask.feature.domain.entity.RemoteCompetitions
import com.example.arabplustask.feature.domain.repo.ICompetitionRepository
import com.example.arabplustask.util.Resource
import javax.inject.Inject

class GetAllCompetition @Inject constructor(
    private val CompetitionsRepo : ICompetitionRepository,
):IGetAllCompetition {
    override suspend fun getAllCompetitions(context: Context): Resource<DomainCompetitions> {
        return CompetitionsRepo.getCompetition(context)
    }

 }