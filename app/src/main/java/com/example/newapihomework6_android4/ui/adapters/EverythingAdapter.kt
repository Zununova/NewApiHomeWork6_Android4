package com.example.newapihomework6_android4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newapihomework6_android4.data.models.everything.EverythingModel
import com.example.newapihomework6_android4.databinding.OneItemBinding

class EverythingAdapter(private val onItemClick: (url: String) -> Unit) :
    ListAdapter<EverythingModel, EverythingAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val binding: OneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                val url: EverythingModel = getItem(absoluteAdapterPosition)
                onItemClick(url.url)
            }
        }

        fun onBind(everything: EverythingModel?) {
            binding.tvTitle.text = everything?.title
            binding.tvAuthor.text = everything?.author ?: "-"
            binding.tvName.text = everything?.source?.name
            Glide.with(binding.ivUrlImage).load(everything?.urlToImage).into(binding.ivUrlImage)
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

    class DiffUtilCallback : DiffUtil.ItemCallback<EverythingModel>() {

        override fun areItemsTheSame(
            oldItem: EverythingModel,
            newItem: EverythingModel
        ): Boolean {
            return oldItem.source.id == newItem.source.id
        }

        override fun areContentsTheSame(
            oldItem: EverythingModel,
            newItem: EverythingModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}