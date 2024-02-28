package com.example.arabplustask.util

import androidx.room.TypeConverter
import com.example.arabplustask.feature.domain.entity.LocalArea
import com.example.arabplustask.feature.domain.entity.LocalCurrentSeason
import com.example.arabplustask.feature.domain.entity.LocalWinner
import com.google.gson.Gson

class AppTypeConverter {
    @TypeConverter
    fun fromArea(area:LocalArea): String {
        return Gson().toJson(area)
    }
    @TypeConverter
    fun toArea(json: String): LocalArea {
        return Gson().fromJson(json, LocalArea::class.java)
    }


    @TypeConverter
    fun fromCurrentSeason(local: LocalCurrentSeason): String {
        return Gson().toJson(local)
    }

    @TypeConverter
    fun toCurrentSeason(json: String): LocalCurrentSeason {
        return Gson().fromJson(json, LocalCurrentSeason::class.java)
    }

    @TypeConverter
    fun fromLocalWinner(winner: LocalWinner): String {
        return Gson().toJson(winner)
    }

    @TypeConverter
    fun toLocalWinner(json: String): LocalWinner {
        return Gson().fromJson(json, LocalWinner::class.java)
    }
}