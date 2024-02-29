package com.example.arabplustask.feature.presentation.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arabplustask.feature.domain.entity.DomainCompetitions
import com.example.arabplustask.feature.domain.usecase.IGetAllCompetition
import com.example.arabplustask.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CompetitionViewModel @Inject constructor(
    private val getAllCompetition: IGetAllCompetition
):ViewModel() {
//    private val _remoteCompetitions = MutableStateFlow<Resource<>>(Resource.Unspecified())
//    val ripPostList : StateFlow<Resource<DomainCompetitions>> = _remoteCompetitions

    init {

    }

//    fun fetchAllCompetitions(){
//        viewModelScope.launch {
//            _remoteCompetitions.emit(Resource.Loading())
//        }
//        viewModelScope.launch {
//            val result = getAllCompetition.getAllCompetitions()
//            _remoteCompetitions.emit()
//        }
//    }

}