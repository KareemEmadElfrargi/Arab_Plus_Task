package com.example.arabplustask.feature.presentation.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arabplustask.feature.domain.entity.DomainCompetitions
import com.example.arabplustask.feature.domain.repo.ICompetitionRepository
import com.example.arabplustask.feature.domain.usecase.IGetAllCompetition
import com.example.arabplustask.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CompetitionViewModel @Inject constructor(
     val repo : ICompetitionRepository
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