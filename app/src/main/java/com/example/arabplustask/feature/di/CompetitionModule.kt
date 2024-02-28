package com.example.arabplustask.feature.di

import com.example.arabplustask.feature.data.data_source.remote.CompetitionRemoteDataImp
import com.example.arabplustask.feature.data.data_source.remote.ICompetitionRemoteData
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
}