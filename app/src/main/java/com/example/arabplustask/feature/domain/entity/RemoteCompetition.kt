package com.example.arabplustask.feature.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class RemoteCompetition(
    @SerializedName("area")
    val area: RemoteArea?,
    @SerializedName("code")
    val code: String?,
    @SerializedName("currentSeason")
    val remoteCurrentSeason: RemoteCurrentSeason?,
    @SerializedName("emblem")
    val emblem: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("lastUpdated")
    val lastUpdated: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("numberOfAvailableSeasons")
    val numberOfAvailableSeasons: Int?,
    @SerializedName("plan")
    val plan: String?,
    @SerializedName("type")
    val type: String?
)

data class DomainCompetition(
    val area: DomainArea?,
    val code: String?,
    val currentSeason: DomainCurrentSeason?,
    val emblem: String?,
    val id: Int?,
    val lastUpdated: String?,
    val name: String?,
    val numberOfAvailableSeasons: Int?,
    val plan: String?,
    val type: String?
)

