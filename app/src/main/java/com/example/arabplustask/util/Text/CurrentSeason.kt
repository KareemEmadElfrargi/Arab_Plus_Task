package com.example.arabplustask.util.Text


import com.google.gson.annotations.SerializedName

data class CurrentSeason(
    @SerializedName("currentMatchday")
    val currentMatchday: Int?,
    @SerializedName("endDate")
    val endDate: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("startDate")
    val startDate: String?,
    @SerializedName("winner")
    val winner: Winner?
)