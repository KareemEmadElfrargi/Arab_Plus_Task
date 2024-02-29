package com.example.scaracademy.features.feature1.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.arabplustask.databinding.FragmentTimelineBinding
import com.example.arabplustask.feature.data.data_source.remote.CompetitionRemoteDataImp
import com.example.arabplustask.feature.data.repo_impl.CompetitionRepositoryImp
import com.example.arabplustask.feature.presentation.common.viewmodel.CompetitionViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TimelineFragment : Fragment() {
    private lateinit var binding: FragmentTimelineBinding
    private  val viewModel: CompetitionViewModel by viewModels()
//    private val competitionAdapter by lazy { CompetitionAdapter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimelineBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dd.setOnClickListener {
            lifecycleScope.launch {
                val data = viewModel.repo.getCompetition(requireContext())
                Log.i("MainActivity","${data.data.toString()} ${data.message.toString()}" )
            }
        }
    }
    private fun setupRecycleView(){

    }
}