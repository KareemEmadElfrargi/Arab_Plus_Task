package com.example.scaracademy.features.feature1.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.arabplustask.R
import com.example.arabplustask.databinding.FragmentTimelineBinding
import com.example.arabplustask.feature.data.data_source.remote.CompetitionRemoteDataImp
import com.example.arabplustask.feature.data.repo_impl.CompetitionRepositoryImp
import com.example.arabplustask.feature.domain.entity.DomainCompetitions
import com.example.arabplustask.feature.presentation.common.adapter.CompetitionAdapter
import com.example.arabplustask.feature.presentation.common.viewmodel.CompetitionViewModel
import com.example.arabplustask.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TimelineFragment : Fragment() {
    private lateinit var binding: FragmentTimelineBinding
    private  val viewModel: CompetitionViewModel by activityViewModels()
    private val competitionAdapter by lazy { CompetitionAdapter(requireContext()) }

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

        lifecycleScope.launch {
            viewModel.fetchAllCompetitions(requireContext())
        }
        lifecycleScope.launch {
            viewModel.competitions.collectLatest { resultOFData ->
                when (resultOFData) {
                    is Resource.Loading -> {
                        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                    }

                    is Resource.Error -> {
                        Toast.makeText(
                            requireContext(),
                            resultOFData.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.i("TimeLine", "onViewCreated: ${resultOFData.message.toString()}")
                    }

                    is Resource.Success -> {
                        resultOFData.data?.let { competitions ->
                            setupRecycleView(competitions)


                        }
                    }

                    is Resource.Unspecified -> Unit
                }

            }
        }
        competitionAdapter.onClick = {
            viewModel.setCompetitionSelected(it)
            findNavController().navigate(R.id.action_timelineFragment_to_competitionDetailsFragment)
        }
    }
    private fun setupRecycleView(competitions:DomainCompetitions){
        competitionAdapter.differ.submitList(competitions.competitions)
        binding.recycleView.adapter = competitionAdapter

    }
}