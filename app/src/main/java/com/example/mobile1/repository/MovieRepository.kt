package com.example.mobile1.repository

import androidx.lifecycle.LiveData
import com.example.mobile1.DAO.MovieDAO
import com.example.mobile1.model.Movie

class MovieRepository(private val movieDAO: MovieDAO) {
    val getMovies: LiveData<List<Movie>> = movieDAO.getMovies()

    suspend fun addMovie (movie: Movie) {
        movieDAO.addMovie(movie)
    }
}