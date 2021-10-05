package com.example.mobile1.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mobile1.database.AppDatabase
import com.example.mobile1.model.Movie
import com.example.mobile1.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(application: Application): AndroidViewModel(application) {
    val repository: MovieRepository
    val getMovies: LiveData<List<Movie>>

    init {
        val movieDAO = AppDatabase.getDatabase(application).movieDAO()
        repository = MovieRepository(movieDAO)
        getMovies = repository.getMovies
    }

    fun addMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMovie(movie)
        }
    }
}