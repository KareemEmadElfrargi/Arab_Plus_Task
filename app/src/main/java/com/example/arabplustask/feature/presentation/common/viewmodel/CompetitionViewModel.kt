package com.example.arabplustask.feature.presentation.common.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.core.view.inputmethod.InputContentInfoCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arabplustask.feature.domain.entity.DomainCompetition
import com.example.arabplustask.feature.domain.entity.DomainCompetitions
import com.example.arabplustask.feature.domain.repo.ICompetitionRepository
import com.example.arabplustask.feature.domain.usecase.IGetAllCompetition
import com.example.arabplustask.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CompetitionViewModel @Inject constructor(
    private val repo : IGetAllCompetition,

):ViewModel(){
    private val _competitions = MutableStateFlow<Resource<DomainCompetitions>>(Resource.Unspecified())
    val competitions : StateFlow<Resource<DomainCompetitions>> = _competitions
    private var itemSelected:DomainCompetition? = null
    fun fetchAllCompetitions(context: Context){
        viewModelScope.launch {
            _competitions.emit(Resource.Loading())
        }
        viewModelScope.launch {
            val result = repo.getAllCompetitions(context)
            _competitions.emit(result)
        }
    }
    fun setCompetitionSelected(domainCompetition: DomainCompetition){
        itemSelected = domainCompetition
    }
    fun getCompetitionSelected():DomainCompetition?{
        return itemSelected
    }

}