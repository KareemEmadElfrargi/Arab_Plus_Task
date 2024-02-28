package com.example.arabplustask.feature.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CompetitionsTable")
data class LocalCompetition(
    val area: LocalArea?= LocalArea(null,null,null,null),
    val code: String?="",
    val currentSeason: LocalCurrentSeason?= LocalCurrentSeason(null,null,null,null,null),
    val emblem: String?,
    @PrimaryKey
    val id: Int,
    val lastUpdated: String?,
    val name: String?,
    val numberOfAvailableSeasons: Int?,
    val plan: String?,
    val type: String?
)