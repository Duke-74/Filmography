package com.example.mobile1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile1.R
import com.example.mobile1.databinding.ActivityMovieListBinding
import com.example.mobile1.databinding.MovieElementBinding
import com.example.mobile1.adapters.MovieAdapter
import com.example.mobile1.viewModel.MovieViewModel
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieList : AppCompatActivity() {
    private lateinit var mMovieViewModel: MovieViewModel

    lateinit var binding: ActivityMovieListBinding
    private val adapter = MovieAdapter()
    val TAG = "MyActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i(TAG, "Совершён переход на activity MovieList")
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        if (::mMovieViewModel.isInitialized) {
            binding.apply {
                list_of_movies.layoutManager = LinearLayoutManager(this@MovieList)
                list_of_movies.adapter = adapter
            }

            mMovieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
            mMovieViewModel.getMovies.observe(this, Observer { movie ->
                adapter.addMovieToList(movie)
            })
        }
    }
}