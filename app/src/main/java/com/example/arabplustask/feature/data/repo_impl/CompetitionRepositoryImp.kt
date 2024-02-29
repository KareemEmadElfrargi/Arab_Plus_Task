package com.example.arabplustask.feature.data.repo_impl

import android.content.Context
import com.example.arabplustask.database.AppDatabase
import com.example.arabplustask.feature.data.data_source.remote.CompetitionRemoteDataImp
import com.example.arabplustask.feature.data.data_source.remote.ICompetitionRemoteData
import com.example.arabplustask.feature.data.mapper.toDomainCompetition
import com.example.arabplustask.feature.data.mapper.toDomainCompetitions
import com.example.arabplustask.feature.data.mapper.toLocalCompetition
import com.example.arabplustask.feature.data.mapper.toLocalCompetitions
import com.example.arabplustask.feature.domain.entity.DomainCompetitions
import com.example.arabplustask.feature.domain.entity.LocalCompetition
import com.example.arabplustask.feature.domain.entity.LocalCompetitions
import com.example.arabplustask.feature.domain.entity.RemoteCompetitions
import com.example.arabplustask.feature.domain.repo.ICompetitionRepository
import com.example.arabplustask.util.Resource
import com.example.arabplustask.util.isInternetAvailable
import javax.inject.Inject

class CompetitionRepositoryImp @Inject constructor(
    private val  competitionRemoteDataSource : ICompetitionRemoteData,
    private val competitionLocalDataSource : AppDatabase
):ICompetitionRepository {
    override suspend fun getCompetition(context: Context): Resource<DomainCompetitions> {
        if (connectivity(context)) {
            return getOnlineCompetition()
        } else {
            return getOfflineCompetition()
        }
    }

     suspend fun getOnlineCompetition(): Resource<DomainCompetitions> {
        val dataFromRemote = getFromRemote()
        if (dataFromRemote.data?.remoteCompetitions!=null){
            saveToLocal(dataFromRemote.data.remoteCompetitions.toLocalCompetition())
            return Resource.Success(dataFromRemote.data.toDomainCompetitions())
        }else {
            return Resource.Error(" repoImp : ${dataFromRemote.message.toString()}")
        }
    }
    private fun getOfflineCompetition():Resource<DomainCompetitions>{
        val data = competitionLocalDataSource.CompetitionDao().getAll()
        if (data!=null){
            return Resource.Success(LocalCompetitions(data).toDomainCompetitions())
        } else {
            return Resource.Error("Database is empty!")
        }
    }


    override suspend fun getFromLocal(): LocalCompetitions {
        val local = competitionLocalDataSource.CompetitionDao().getAll()
        return LocalCompetitions(local)
    }

    override suspend fun getFromRemote(): Resource<RemoteCompetitions> {
        val dataFromRemote = competitionRemoteDataSource.getCompetition()
        if (dataFromRemote.data == null){
            return Resource.Error(dataFromRemote.message.toString())
        } else {
            return Resource.Success(dataFromRemote.data)
        }
    }

    override suspend fun saveToLocal(data: List<LocalCompetition>) {
       competitionLocalDataSource.CompetitionDao().insert(data)
    }

    fun connectivity(context:Context):Boolean{
        return context.isInternetAvailable()
    }
}