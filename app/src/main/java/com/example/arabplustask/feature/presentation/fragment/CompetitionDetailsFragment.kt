package com.example.scaracademy.features.feature1.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.arabplustask.databinding.FragmentCompetitionDetailsBinding
import com.example.arabplustask.feature.presentation.common.viewmodel.CompetitionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompetitionDetailsFragment: Fragment() {
    private lateinit var binding : FragmentCompetitionDetailsBinding
    private  val viewModel: CompetitionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompetitionDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val competition = viewModel.getCompetitionSelected()

        binding.apply {
            competition?.let {
                areaTv.text = competition.area.toString()
                lastUpdateTv.text = competition.lastUpdated
                startDateTv.text = competition.currentSeason?.startDate
                endDateTv.text = competition.currentSeason?.endDate
                matchdayTv.text = competition.currentSeason?.currentMatchday.toString()
                numberOfAvailableSeasonTv.text = competition.numberOfAvailableSeasons.toString()
                competition.emblem?.let {
                    Glide.with(requireContext()).load(it).into(emblemIv)
                }


            }

        }
    }
}