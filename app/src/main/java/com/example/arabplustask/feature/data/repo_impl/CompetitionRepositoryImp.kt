package com.example.arabplustask.feature.data.repo_impl

import com.example.arabplustask.database.AppDatabase
import com.example.arabplustask.feature.data.data_source.remote.CompetitionRemoteDataImp
import com.example.arabplustask.feature.data.data_source.remote.ICompetitionRemoteData
import com.example.arabplustask.feature.data.mapper.toLocalCompetition
import com.example.arabplustask.feature.data.mapper.toLocalCompetitions
import com.example.arabplustask.feature.domain.entity.LocalCompetition
import com.example.arabplustask.feature.domain.entity.LocalCompetitions
import com.example.arabplustask.feature.domain.entity.RemoteCompetitions
import com.example.arabplustask.feature.domain.repo.ICompetitionRepository
import com.example.arabplustask.util.Resource
import javax.inject.Inject

class CompetitionRepositoryImp @Inject constructor(
    private val  competitionRemoteDataSource : ICompetitionRemoteData
    , private val competitionLocalDataSource : AppDatabase
):ICompetitionRepository {
    override suspend fun getCompetition(): Resource<RemoteCompetitions> {
        val dataFromRemote = getFromRemote()
        if (dataFromRemote.data?.remoteCompetitions!=null){
            saveToLocal(dataFromRemote.data.remoteCompetitions.toLocalCompetition())
            return dataFromRemote
        }else {
            return Resource.Error("x")
        }
    }

    override suspend fun getFromLocal(): LocalCompetitions {
        val local = competitionLocalDataSource.CompetitionDao().getAll()
        return LocalCompetitions(local)
    }

    override suspend fun getFromRemote(): Resource<RemoteCompetitions> {
        val dataFromRemote = competitionRemoteDataSource.getCompetition()
        if (dataFromRemote.data==null){
            return Resource.Error(dataFromRemote.message.toString())
        } else {
            return Resource.Success(dataFromRemote.data)
        }
    }

    override suspend fun saveToLocal(data: List<LocalCompetition>) {
       competitionLocalDataSource.CompetitionDao().insert(data)
    }
}