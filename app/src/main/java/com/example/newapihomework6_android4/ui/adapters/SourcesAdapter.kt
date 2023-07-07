package com.example.newapihomework6_android4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newapihomework6_android4.data.models.source.SourcesModel
import com.example.newapihomework6_android4.databinding.OneItemBinding

class SourcesAdapter( private val onClick: (url: String) -> Unit) :
    ListAdapter<SourcesModel, SourcesAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val binding: OneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                val model: SourcesModel = getItem(absoluteAdapterPosition)
                onClick(model.url)
            }
        }

        fun onBind(sourcesModel: SourcesModel?) {
            binding.tvTitle.text = sourcesModel?.description
            binding.tvName.text = sourcesModel?.name
            binding.visibleText.isInvisible = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            OneItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<SourcesModel>() {

        override fun areItemsTheSame(
            oldItem: SourcesModel,
            newItem: SourcesModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: SourcesModel,
            newItem: SourcesModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}