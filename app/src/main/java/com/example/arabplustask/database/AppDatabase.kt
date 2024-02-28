package com.example.arabplustask.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.arabplustask.feature.data.data_source.local.ICompetitionDao
import com.example.arabplustask.feature.domain.entity.LocalCompetition
import com.example.arabplustask.util.AppTypeConverter

@TypeConverters(value = [AppTypeConverter::class])
@Database(entities = [LocalCompetition::class], version = 2, exportSchema = false)
abstract class AppDatabase :RoomDatabase() {
    abstract fun CompetitionDao() : ICompetitionDao
}
