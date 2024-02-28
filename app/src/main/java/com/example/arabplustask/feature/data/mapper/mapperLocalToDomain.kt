package com.example.arabplustask.feature.data.mapper

import com.example.arabplustask.feature.domain.entity.DomainArea
import com.example.arabplustask.feature.domain.entity.DomainCompetition
import com.example.arabplustask.feature.domain.entity.DomainCompetitions
import com.example.arabplustask.feature.domain.entity.DomainCurrentSeason
import com.example.arabplustask.feature.domain.entity.DomainWinner
import com.example.arabplustask.feature.domain.entity.LocalArea
import com.example.arabplustask.feature.domain.entity.LocalCompetition
import com.example.arabplustask.feature.domain.entity.LocalCompetitions
import com.example.arabplustask.feature.domain.entity.LocalCurrentSeason
import com.example.arabplustask.feature.domain.entity.LocalWinner


fun LocalCompetitions.toDomainCompetitions() : DomainCompetitions{
   return DomainCompetitions(
       competitions = this.competitions?.toDomainCompetition(),
       count = this.competitions?.size
   )
}
fun List<LocalCompetition>.toDomainCompetition() : List<DomainCompetition> {
    return map {
        DomainCompetition(
         area=it.area?.toDomainArea(),
         code=it.code,
         currentSeason =  it.currentSeason?.toDomainCurrentSeason(),
         emblem = it.emblem,
         id = it.id,
         lastUpdated = it.lastUpdated,
         name =  it.name,
         numberOfAvailableSeasons = it.numberOfAvailableSeasons,
         plan = it.plan,
         type = it.type

        )
    }
}

fun LocalArea.toDomainArea()= DomainArea(
    code = code, flag = flag, id = id, name = name
)
fun LocalCurrentSeason.toDomainCurrentSeason() = DomainCurrentSeason(
    currentMatchday =currentMatchday,
    endDate = endDate,
    id = id,
    startDate = startDate,
    winner = winner?.toDomainWinner()
)
fun LocalWinner.toDomainWinner() = DomainWinner(
    address = address,
    clubColors=clubColors,
    crest=crest,
    founded=founded,
    id=id,
    lastUpdated=lastUpdated,
    name=name,
    shortName=shortName,
    tla=tla,
    venue=venue,
    website = website
)