package com.example.arabplustask.feature.domain.entity


import com.google.gson.annotations.SerializedName

data class RemoteCurrentSeason(
    @SerializedName("currentMatchday")
    val currentMatchday: Int?,
    @SerializedName("endDate")
    val endDate: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("startDate")
    val startDate: String?,
    @SerializedName("winner")
    val winner: RemoteWinner?
)

data class LocalCurrentSeason(
    val currentMatchday: Int?,
    val endDate: String?,
    val id: Int?,
    val startDate: String?,
    val winner: LocalWinner?
)

data class DomainCurrentSeason(
    val currentMatchday: Int?,
    val endDate: String?,
    val id: Int?,
    val startDate: String?,
    val winner: DomainWinner?
)