package com.example.movieupdate.ui.main.views.movie_detail.adapter

import android.animation.ObjectAnimator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieupdate.R
import com.example.movieupdate.model.Review


class ReviewAdapter(
    private val reviewList: List<Review>,
) : RecyclerView.Adapter<ReviewAdapter.CastViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReviewAdapter.CastViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.review_items, null)
        return CastViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }

    override fun onBindViewHolder(viewHolder: CastViewHolder, position: Int) {
        val review: Review = reviewList[position]

        viewHolder.tvContentReview.apply {
            text = review.content
            maxLines = 2
        }
        review.author_details.apply {
        }
        if (review.author_details.avatar_path.isNullOrEmpty() || review.author_details.avatar_path == "null" || review.author_details.avatar_path.isNullOrBlank() || review.author_details.avatar_path == null) {
            viewHolder.profileAuthors.setImageResource(R.drawable.ic_people_24)
        }else{
            Glide.with(viewHolder.profileAuthors.context)
                .load(viewHolder.profileAuthors.context.getString(R.string.w220h330) + review.author_details.avatar_path)
                .apply(RequestOptions().centerCrop())
                .into(viewHolder.profileAuthors)
        }
    }


    inner class CastViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileAuthors: ImageView = itemView.findViewById(R.id.profileAuthor)
        val tvContentReview: TextView = itemView.findViewById(R.id.contentReview)
    }
}
