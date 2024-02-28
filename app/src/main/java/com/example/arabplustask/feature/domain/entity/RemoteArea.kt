package com.example.arabplustask.feature.domain.entity


import com.google.gson.annotations.SerializedName

data class RemoteArea(
    @SerializedName("code")
    val code: String?,
    @SerializedName("flag")
    val flag: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)
data class LocalArea(
    val code: String?,
    val flag: String?,
    val id: Int?,
    val name: String?
)
data class DomainArea(
    val code: String?,
    val flag: String?,
    val id: Int?,
    val name: String?
)