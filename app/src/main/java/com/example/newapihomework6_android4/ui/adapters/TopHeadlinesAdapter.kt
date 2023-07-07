package com.example.newapihomework6_android4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newapihomework6_android4.data.models.topheadlines.TopHeadlinesModel
import com.example.newapihomework6_android4.databinding.OneItemBinding

class TopHeadlinesAdapter( private val onClick: (url: String) -> Unit) :
    ListAdapter<TopHeadlinesModel, TopHeadlinesAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val binding: OneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                val model: TopHeadlinesModel = getItem(absoluteAdapterPosition)
                onClick(model.url)
            }
        }

        fun onBind(topHeadlines: TopHeadlinesModel?) {
            binding.tvTitle.text = topHeadlines?.title
            binding.tvAuthor.text = topHeadlines?.author ?: "-"
            binding.tvName.text = topHeadlines?.source?.name
            Glide.with(binding.ivUrlImage).load(topHeadlines?.urlToImage).into(binding.ivUrlImage)
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

    class DiffUtilCallback : DiffUtil.ItemCallback<TopHeadlinesModel>() {

        override fun areItemsTheSame(
            oldItem: TopHeadlinesModel,
            newItem: TopHeadlinesModel
        ): Boolean {
            return oldItem.source.id == newItem.source.id
        }

        override fun areContentsTheSame(
            oldItem: TopHeadlinesModel,
            newItem: TopHeadlinesModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}