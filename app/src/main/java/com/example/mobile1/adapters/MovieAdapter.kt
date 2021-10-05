package com.example.mobile1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile1.R
import com.example.mobile1.model.Movie
import com.example.mobile1.databinding.MovieElementBinding
import kotlinx.android.synthetic.main.movie_element.view.*

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var movieList = emptyList<Movie>()

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = MovieElementBinding.bind(itemView)

        fun bind(movie: Movie) = with(binding) {
            movieNameElement.text = movie.movieName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_element, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun addMovieToList(movie: List<Movie>) {
        this.movieList = movie
        notifyDataSetChanged()
    }
}