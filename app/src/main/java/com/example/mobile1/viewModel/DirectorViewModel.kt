package com.example.mobile1.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mobile1.database.AppDatabase
import com.example.mobile1.model.Director
import com.example.mobile1.repository.DirectorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DirectorViewModel(application: Application): AndroidViewModel(application) {
    val repository: DirectorRepository
    val getUsers: LiveData<List<Director>>

    init {
        val directorDAO = AppDatabase.getDatabase(application).directorDAO()
        repository = DirectorRepository(directorDAO)
        getUsers = repository.getDirectors
    }

    fun addDirector(director: Director) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDirector(director)
        }
    }
}