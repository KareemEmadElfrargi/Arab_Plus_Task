package com.example.scaracademy.features.feature1.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.arabplustask.databinding.FragmentCompetitionDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompetitionDetailsFragment: Fragment() {
    private lateinit var binding : FragmentCompetitionDetailsBinding
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
    }
}