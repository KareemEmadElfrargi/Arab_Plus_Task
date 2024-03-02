package com.example.arabplustask.feature.data.data_source.remote

import com.example.arabplustask.Secure.TLSSocketFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStream

// old method without hilt
object RetrofitClient {
    private const val BASE_URL = "http://api.football-data.org/v4/"
    private var footballApiService: FootballApiService? = null
    fun getInstance(): FootballApiService {
        if (footballApiService == null) {
            synchronized(RetrofitClient::class.java) {
                if (footballApiService == null) {
                    val retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                    footballApiService = retrofit.create(FootballApiService::class.java)
                }
            }
        }
        return footballApiService!!
    }


}