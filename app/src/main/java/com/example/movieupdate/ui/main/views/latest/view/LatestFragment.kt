package com.example.movieupdate.ui.main.views.latest.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieupdate.R
import com.example.movieupdate.ui.main.views.latest.adapter.LatestAdapter
import com.example.movieupdate.ui.main.views.latest.viewmodel.LatestViewModel
import com.example.movieupdate.base.BaseFragment
import com.example.movieupdate.util.ItemClickListener
import com.example.movieupdate.databinding.FragmentLatestBinding
import com.example.movieupdate.ui.main.views.movie_detail.view.MovieDetailActivity
import com.example.movieupdate.model.Movie
import com.example.movieupdate.model.Result

class LatestFragment : BaseFragment<LatestViewModel, FragmentLatestBinding>(),
    ItemClickListener<Movie> {

    override val binding: FragmentLatestBinding by lazy {
        FragmentLatestBinding.inflate(
            layoutInflater
        )
    }

    companion object {
        fun newInstance() = LatestFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLatestMovie().observe(viewLifecycleOwner) {
            if (it is Result.Success) {
                println("succes: $it")
                val recyclerAdapter = LatestAdapter(this, it.data)
                binding.recyclerview.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = recyclerAdapter
                }
            } else {
                println("error: $it")
            }
        }

        binding.tView.apply {
            text = getString(R.string.latest)
        }
    }

    override fun onItemClicked(v: View, data: Movie) {
        val intent = Intent(context, MovieDetailActivity::class.java)
        intent.putExtra("movieid", data.id)
        startActivity(intent)
    }
}