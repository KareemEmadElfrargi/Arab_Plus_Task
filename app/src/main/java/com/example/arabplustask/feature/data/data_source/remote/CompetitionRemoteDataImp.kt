package com.example.arabplustask.feature.data.data_source.remote

import android.util.Log
import com.example.arabplustask.feature.domain.entity.RemoteCompetitions
import com.example.arabplustask.util.Resource
import com.example.arabplustask.util.secretData

class CompetitionRemoteDataImp:ICompetitionRemoteData {
    override suspend fun getCompetition(): Resource<RemoteCompetitions> {
        val apiService = RetrofitClient.create()
        try {
            val competition = apiService.getCompetitions(secretData)
            Log.i("CompetitionRemoteDataImp", "getCompetition: ${competition.body().toString()}")
            if (competition.isSuccessful){
                competition.body()?.let {
                    return Resource.Success(it)
                } ?: return Resource.Success(RemoteCompetitions(null,null,null))
            }else{
                return Resource.Error(competition.message().toString())
            }

        }catch (e:Exception){
            return Resource.Error(e.message.toString())
        }
    }
}