package com.example.movieupdate.ui.main.views.top_rated.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.movieupdate.R
import com.example.movieupdate.ui.main.views.top_rated.adapter.TopRatedAdapter
import com.example.movieupdate.ui.main.views.top_rated.viewmodel.TopRatedViewModel
import com.example.movieupdate.base.BaseFragment
import com.example.movieupdate.util.ItemClickListener
import com.example.movieupdate.widget.dialog.ProgressDialog
import com.example.movieupdate.databinding.FragmentTopRatedBinding
import com.example.movieupdate.ui.main.views.movie_detail.view.MovieDetailActivity
import com.example.movieupdate.model.Movie
import com.example.movieupdate.model.Result
import com.example.movieupdate.util.RecyclerViewScrollListener

class TopRatedFragment : BaseFragment<TopRatedViewModel, FragmentTopRatedBinding>(),
    ItemClickListener<Movie>, SwipeRefreshLayout.OnRefreshListener, RecyclerViewScrollListener.ScrollCallback {

    private var allMovies = arrayListOf<Movie>()
    private var progressDialog: ProgressDialog? = null
    private var page: Int = 1
    private var totalResults: Int = -1
    private var isLoading: Boolean = false

    private val topRatedAdapter: TopRatedAdapter = TopRatedAdapter(this)
    private val mScrollListener by lazy { RecyclerViewScrollListener(this) }

    override val binding: FragmentTopRatedBinding by lazy {
        FragmentTopRatedBinding.inflate(
            layoutInflater
        )
    }

    companion object {
        fun newInstance() = TopRatedFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.swipe.setOnRefreshListener(this)
        progressDialog = context?.let { ProgressDialog(it) }

        setRecyclerView()
        setFragmentTitle()
        getTopRatedMovies(page = page)
    }

    private fun setRecyclerView() {
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = topRatedAdapter
            addOnScrollListener(mScrollListener)
        }
    }

    private fun setFragmentTitle() {
        binding.tView.apply {
            text = getString(R.string.top_rated)
        }
    }

    private fun getTopRatedMovies(page: Int) {
        progressDialog?.show()
        viewModel.getTopRatedMovies(page = page).observe(viewLifecycleOwner) {
            when (it) {
                is Result.Success -> {
                    println("SuccessTopRatedMovies: $it")
                    if (it.data.results != null) {
                        totalResults = it.data.totalResults
                        allMovies.addAll(it.data.results)
                        topRatedAdapter.submitList(allMovies)
                        isLoading = false
                    }
                }
                else -> {
                    println("ErrorTopRatedMovies: $it")
                }
            }
            if (progressDialog?.isShowing == true) {
                progressDialog?.dismiss()
            }
            binding.swipe.isRefreshing = false
        }
    }

    override fun onItemClicked(v: View, data: Movie) {
        val intent = Intent(context, MovieDetailActivity::class.java)
        intent.putExtra("movieid", data.id)
        startActivity(intent)
    }

    override fun onRefresh() {
        page = 1
        allMovies.clear()
        getTopRatedMovies(page = page)
    }

    override fun onScrollCompleted(firstVisibleItem: Int, isLoadingMoreData: Boolean) {
        if (allMovies.size != totalResults) {
            if (!isLoading) {
                progressDialog!!.show()
                isLoading = true
                page = page.plus(1)
                getTopRatedMovies(page = page)
            }
        }
    }
}