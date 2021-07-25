package com.example.colourmemory.ui.scores

import android.content.pm.ActivityInfo
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import com.example.colourmemory.R
import com.example.colourmemory.databinding.FragmentScoresBinding
import com.example.core.base.BaseActivity
import com.example.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HighScoresFragment :
    BaseFragment<FragmentScoresBinding, ScoresViewModel>(R.layout.fragment_scores) {
    override fun getViewModelClass(): Class<ScoresViewModel> = ScoresViewModel::class.java

    override fun getViewModelOwner(): ViewModelStoreOwner = this

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as BaseActivity).requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        binding.lifecycleOwner = viewLifecycleOwner
        binding.scoresRecycler.adapter = ScoresAdapter()
        viewModel.getAllScores().observe(viewLifecycleOwner, Observer {
            (binding.scoresRecycler.adapter as ScoresAdapter).updateList(it)
        })
        binding.btnBack.setOnClickListener {
            findNavController().graph =
                findNavController().navInflater.inflate(R.navigation.game_graph)
        }
    }

    override fun onDestroyView() {
        (activity as BaseActivity).requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onDestroyView()
    }
}