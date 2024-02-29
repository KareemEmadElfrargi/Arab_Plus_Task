package com.example.arabplustask.feature.data.data_source.remote

import android.util.Log
import com.example.arabplustask.feature.domain.entity.RemoteCompetitions
import com.example.arabplustask.util.Resource
import com.example.arabplustask.util.secretData

class CompetitionRemoteDataImp:ICompetitionRemoteData {
    override suspend fun getCompetition(): Resource<RemoteCompetitions> {
        val apiService = RetrofitClient.create()
        try {
            val competitionsResponse = apiService.getCompetitions(secretData)
            Log.i("CompetitionRemoteDataImp", "getCompetitionResponse: ${competitionsResponse.body().toString()}")
            if (competitionsResponse.isSuccessful){
                competitionsResponse.body()?.let {
                    return Resource.Success(it)
                } ?: return Resource.Success(RemoteCompetitions(null,null,null))
            }else{
                return Resource.Error(competitionsResponse.message().toString())
            }
        }catch (e:Exception){
            return Resource.Error(" fetch api message : ${e.message.toString()}")
        }
    }
}