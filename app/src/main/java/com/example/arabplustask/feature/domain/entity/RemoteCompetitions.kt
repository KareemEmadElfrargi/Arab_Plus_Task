package com.example.arabplustask.feature.domain.entity


import com.google.gson.annotations.SerializedName

data class RemoteCompetitions(
    @SerializedName("competitions")
    val remoteCompetitions: List<RemoteCompetition>?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("filters")
    val filters: Filters?
)
data class LocalCompetitions(
    val competitions: List<LocalCompetition>?,

)

data class DomainCompetitions(
    val competitions: List<DomainCompetition>?,
    val count: Int?,
)