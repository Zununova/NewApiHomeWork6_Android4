package com.example.newapihomework6_android4.ui.fragments.home.topheadlines

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newapihomework6_android4.R
import com.example.newapihomework6_android4.base.BaseFragment
import com.example.newapihomework6_android4.databinding.FragmentTopHeadlinesBinding
import com.example.newapihomework6_android4.ui.adapters.TopHeadlinesAdapter
import com.example.newapihomework6_android4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopHeadlinesFragment :
    BaseFragment<FragmentTopHeadlinesBinding, TopHeadlinesViewModel>(R.layout.fragment_top_headlines) {

    override val binding by viewBinding(FragmentTopHeadlinesBinding::bind)
    override val viewModel: TopHeadlinesViewModel by viewModels()
    private val topHeadlinesAdapter = TopHeadlinesAdapter(this::onClick)

    private fun onClick(url: String){
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    override fun initialize() = with(binding.rvTopHeadlines) {
        adapter = topHeadlinesAdapter
        layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun setupSubscribes() {

        lifecycleScope.launch {
            viewModel.fetchTopHeadlines().collect() {
                when (it) {
                    is Resource.Error -> Toast.makeText(
                        requireContext(),
                        "error",
                        Toast.LENGTH_SHORT
                    ).show()
                    is Resource.Loading -> Toast.makeText(
                        requireContext(),
                        "loading",
                        Toast.LENGTH_SHORT
                    ).show()
                    is Resource.Success -> topHeadlinesAdapter.submitList(it.data?.articles)
                }
            }
        }
    }
}