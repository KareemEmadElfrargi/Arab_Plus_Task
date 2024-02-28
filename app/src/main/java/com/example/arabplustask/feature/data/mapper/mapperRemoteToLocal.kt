package com.example.arabplustask.feature.data.mapper

import com.example.arabplustask.feature.domain.entity.LocalArea
import com.example.arabplustask.feature.domain.entity.LocalCompetition
import com.example.arabplustask.feature.domain.entity.LocalCompetitions
import com.example.arabplustask.feature.domain.entity.LocalCurrentSeason
import com.example.arabplustask.feature.domain.entity.LocalWinner
import com.example.arabplustask.feature.domain.entity.RemoteArea
import com.example.arabplustask.feature.domain.entity.RemoteCompetition
import com.example.arabplustask.feature.domain.entity.RemoteCompetitions
import com.example.arabplustask.feature.domain.entity.RemoteCurrentSeason
import com.example.arabplustask.feature.domain.entity.RemoteWinner

fun RemoteCompetitions.toLocalCompetitions() = LocalCompetitions(
    competitions = remoteCompetitions?.toLocalCompetition()
)
fun List<RemoteCompetition>.toLocalCompetition() : List<LocalCompetition> {
    return map {
        LocalCompetition(
            area = it.area?.toLocalArea(),
            code = it.code ,
            currentSeason = it.remoteCurrentSeason?.toLocalCurrentSeason(),
            emblem = it.emblem,
            id = it.id ?: 0,
            lastUpdated = it.lastUpdated,
            name = it.name,
            numberOfAvailableSeasons = it.numberOfAvailableSeasons,
            plan = it.plan,
            type = it.type
        )
    }
}

fun RemoteArea.toLocalArea()= LocalArea(
    code = code, flag = flag, id = id, name = name
)
fun RemoteCurrentSeason.toLocalCurrentSeason() = LocalCurrentSeason(
    currentMatchday =currentMatchday,
    endDate = endDate,
    id = id,
    startDate = startDate,
    winner = winner?.toLocalWinner()
)
fun RemoteWinner.toLocalWinner() = LocalWinner(
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