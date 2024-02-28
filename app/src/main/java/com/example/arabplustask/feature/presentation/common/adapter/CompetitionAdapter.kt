package com.example.arabplustask.feature.presentation.common.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.arabplustask.databinding.ItemBinding
import com.example.scaracademy.features.feature1.data.model.Competition

class CompetitionAdapter(val context: Context) : RecyclerView.Adapter<CompetitionAdapter.CompetitionViewHolder>() {
    inner class CompetitionViewHolder (val binding : ItemBinding) : ViewHolder(binding.root){
        fun bind (competition:Competition){
            binding.apply {
                competitionName.text = competition.name
                competitionArea.text = competition.areaName
                competition.emblemUrl?.let {
                    Glide.with(context).
                    load(it).
                    into(competitionEmblem)
                }
            }
        }
    }

    private val diffUtil = object : DiffUtil.ItemCallback<Competition>(){
        override fun areItemsTheSame(oldItem: Competition, newItem: Competition): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Competition, newItem: Competition): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this@CompetitionAdapter,diffUtil)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionViewHolder {
        return CompetitionViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int  = differ.currentList.size

    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        val currentCompetition = differ.currentList[position]
        holder.bind(currentCompetition)
        holder.binding.cardContainer.setOnClickListener {
            onClick?.invoke(currentCompetition)
        }

    }
    var onClick : ((Competition)->Unit)? = null
}
