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
import com.example.arabplustask.feature.domain.entity.DomainCompetition
import com.example.arabplustask.feature.domain.entity.DomainCompetitions

class CompetitionAdapter(val context: Context) : RecyclerView.Adapter<CompetitionAdapter.CompetitionViewHolder>() {
    inner class CompetitionViewHolder(val binding: ItemBinding) : ViewHolder(binding.root) {
        fun bind(competition: DomainCompetition) {
            binding.apply {
                competitionName.text = competition.name
                competitionArea.text = competition.area?.name
                competition.emblem?.let {
                    Glide.with(context).load(it).into(competitionEmblem)
                }
            }
        }
    }

    private val diffUtil = object : DiffUtil.ItemCallback<DomainCompetition>() {
        override fun areItemsTheSame(
            oldItem: DomainCompetition,
            newItem: DomainCompetition
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DomainCompetition,
            newItem: DomainCompetition
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this@CompetitionAdapter, diffUtil)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionViewHolder {
        return CompetitionViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int = differ.currentList.size
    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        val currentCompetition = differ.currentList[position]
        holder.bind(currentCompetition)
        holder.binding.cardContainer.setOnClickListener {
            onClick?.invoke(currentCompetition)

        }

    }
    var onClick: ((DomainCompetition) -> Unit)? = null
}
