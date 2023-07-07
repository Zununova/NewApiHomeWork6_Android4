package com.example.newapihomework6_android4.ui.fragments.home.sources

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newapihomework6_android4.R
import com.example.newapihomework6_android4.base.BaseFragment
import com.example.newapihomework6_android4.databinding.FragmentSourcesBinding
import com.example.newapihomework6_android4.ui.adapters.SourcesAdapter
import com.example.newapihomework6_android4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SourcesFragment :
    BaseFragment<FragmentSourcesBinding, SourcesViewModel>(R.layout.fragment_sources) {

    override val binding by viewBinding(FragmentSourcesBinding::bind)
    override val viewModel: SourcesViewModel by viewModels()
    private val sourcesAdapter = SourcesAdapter(this::onClick)

    private fun onClick(url: String){
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    override fun initialize() = with(binding.rvSources) {
        adapter = sourcesAdapter
        layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun setupSubscribes() {

        lifecycleScope.launch {
            viewModel.fetchSources().collect {
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
                    is Resource.Success -> sourcesAdapter.submitList(it.data?.sources)
                }
            }
        }
    }
}