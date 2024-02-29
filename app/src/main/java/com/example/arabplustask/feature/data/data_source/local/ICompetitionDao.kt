package com.example.arabplustask.feature.data.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.arabplustask.feature.domain.entity.LocalCompetition
import com.example.arabplustask.feature.domain.entity.LocalCompetitions
@Dao
interface ICompetitionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert( listOfCompetition : List<LocalCompetition>)

    @Query("SELECT * FROM CompetitionsTable")
     fun getAll(): List<LocalCompetition>?

}