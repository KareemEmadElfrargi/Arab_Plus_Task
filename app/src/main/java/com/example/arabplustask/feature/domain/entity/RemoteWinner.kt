package com.example.arabplustask.feature.domain.entity


import com.google.gson.annotations.SerializedName

data class RemoteWinner(
    @SerializedName("address")
    val address: String?,
    @SerializedName("clubColors")
    val clubColors: String?,
    @SerializedName("crest")
    val crest: String?,
    @SerializedName("founded")
    val founded: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("lastUpdated")
    val lastUpdated: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("shortName")
    val shortName: String?,
    @SerializedName("tla")
    val tla: String?,
    @SerializedName("venue")
    val venue: String?,
    @SerializedName("website")
    val website: String?
)
data class LocalWinner(
    val address: String?,
    val clubColors: String?,
    val crest: String?,
    val founded: Int?,
    val id: Int?,
    val lastUpdated: String?,
    val name: String?,
    val shortName: String?,
    val tla: String?,
    val venue: String?,
    val website: String?
)
data class DomainWinner(
    val address: String?,
    val clubColors: String?,
    val crest: String?,
    val founded: Int?,
    val id: Int?,
    val lastUpdated: String?,
    val name: String?,
    val shortName: String?,
    val tla: String?,
    val venue: String?,
    val website: String?
)