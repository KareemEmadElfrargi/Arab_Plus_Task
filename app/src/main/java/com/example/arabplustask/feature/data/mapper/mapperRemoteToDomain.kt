package com.example.arabplustask.feature.data.mapper

import com.example.arabplustask.feature.domain.entity.DomainArea
import com.example.arabplustask.feature.domain.entity.DomainCompetition
import com.example.arabplustask.feature.domain.entity.DomainCompetitions
import com.example.arabplustask.feature.domain.entity.DomainCurrentSeason
import com.example.arabplustask.feature.domain.entity.DomainWinner
import com.example.arabplustask.feature.domain.entity.RemoteArea
import com.example.arabplustask.feature.domain.entity.RemoteCompetition
import com.example.arabplustask.feature.domain.entity.RemoteCompetitions
import com.example.arabplustask.feature.domain.entity.RemoteCurrentSeason
import com.example.arabplustask.feature.domain.entity.RemoteWinner

fun RemoteCompetitions.toDomainCompetitions() = DomainCompetitions(
    competitions = remoteCompetitions?.toDomainCompetition(),
    count = count,
)
fun List<RemoteCompetition>.toDomainCompetition() : List<DomainCompetition>{
    return map {
        DomainCompetition(
            area = it.area?.toDomainArea(),
            code = it.code ,
            currentSeason = it.remoteCurrentSeason?.toDomainCurrentSeason(),
            emblem = it.emblem,
            id = it.id,
            lastUpdated = it.lastUpdated,
            name = it.name,
            numberOfAvailableSeasons = it.numberOfAvailableSeasons,
            plan = it.plan,
            type = it.type
        )
    }

}

fun RemoteArea.toDomainArea()= DomainArea(
    code = code, flag = flag, id = id, name = name
)
fun RemoteCurrentSeason.toDomainCurrentSeason() = DomainCurrentSeason(
    currentMatchday =currentMatchday,
    endDate = endDate,
    id = id,
    startDate = startDate,
    winner  = winner?.toDomainWinner()
)
fun RemoteWinner.toDomainWinner() = DomainWinner(
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