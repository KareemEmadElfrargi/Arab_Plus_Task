package com.example.arabplustask.util.Text


import com.google.gson.annotations.SerializedName

data class Co(
    @SerializedName("competitions")
    val competitions: List<Competition?>?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("filters")
    val filters: Filters?
)