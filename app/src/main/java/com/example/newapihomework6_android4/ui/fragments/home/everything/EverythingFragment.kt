package com.example.newapihomework6_android4.ui.fragments.home.everything

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newapihomework6_android4.R
import com.example.newapihomework6_android4.base.BaseFragment
import com.example.newapihomework6_android4.databinding.FragmentEverythingBinding
import com.example.newapihomework6_android4.ui.adapters.EverythingAdapter
import com.example.newapihomework6_android4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EverythingFragment :
    BaseFragment<FragmentEverythingBinding, EverythingViewModel>(R.layout.fragment_everything) {

    override val binding by viewBinding(FragmentEverythingBinding::bind)
    override val viewModel: EverythingViewModel by viewModels()
    private val everythingAdapter = EverythingAdapter(this::onClick)

    private fun onClick(url: String) {
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    override fun initialize() = with(binding.rvEverything) {
        adapter = everythingAdapter
        layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun setupSubscribes() {

        lifecycleScope.launch {
            viewModel.fetchEverything().collect() {
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
                    is Resource.Success -> everythingAdapter.submitList(it.data?.articles)
                }
            }
        }
    }
}