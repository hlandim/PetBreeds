package com.hlandim.petbreed.bread.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hlandim.petbreed.bread.viewmodel.BreedsViewModel
import com.hlandim.petbreed.databinding.BreedsFragmentBinding


class BreedsFragment : Fragment() {

    lateinit var breadViewModel: BreedsViewModel

    companion object {
        fun newInstance(viewModel: BreedsViewModel): BreedsFragment {
            val fragment = BreedsFragment()
            val extras = Bundle()
            extras.putSerializable("viewModel", viewModel)
            fragment.arguments = extras
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: BreedsFragmentBinding = BreedsFragmentBinding.inflate(inflater, container, false)
        breadViewModel = arguments?.get("viewModel") as BreedsViewModel
        binding.viewModel = breadViewModel

        binding.recyclerView.adapter = BreedsAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        breadViewModel.load()
    }

}