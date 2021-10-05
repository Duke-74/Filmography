package com.example.mobile1.repository

import androidx.lifecycle.LiveData
import com.example.mobile1.DAO.DirectorDAO
import com.example.mobile1.model.Director

class DirectorRepository(private val directorDAO: DirectorDAO) {
    val getDirectors: LiveData<List<Director>> = directorDAO.getDirectors()

    suspend fun addDirector (director: Director) {
        directorDAO.addDirector(director)
    }
}