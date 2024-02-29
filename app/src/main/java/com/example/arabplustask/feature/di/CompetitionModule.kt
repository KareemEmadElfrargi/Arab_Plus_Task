package com.example.arabplustask.feature.di

import com.example.arabplustask.database.AppDatabase
import com.example.arabplustask.feature.data.data_source.remote.CompetitionRemoteDataImp
import com.example.arabplustask.feature.data.data_source.remote.ICompetitionRemoteData
import com.example.arabplustask.feature.data.repo_impl.CompetitionRepositoryImp
import com.example.arabplustask.feature.domain.repo.ICompetitionRepository
import com.example.arabplustask.feature.domain.usecase.GetAllCompetition
import com.example.arabplustask.feature.domain.usecase.IGetAllCompetition
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object CompetitionModule {
    @Provides
    fun provideCompetitionDataSourceRemote() :
            ICompetitionRemoteData = CompetitionRemoteDataImp()
    @Provides
    fun provideCompetitionRepo(
        competitionRemoteData : ICompetitionRemoteData,databaseApp: AppDatabase
    ) : ICompetitionRepository = CompetitionRepositoryImp(competitionRemoteData,databaseApp)

    @Provides
    fun provideCompetitionUseCase(repo:ICompetitionRepository): IGetAllCompetition = GetAllCompetition(repo)
}