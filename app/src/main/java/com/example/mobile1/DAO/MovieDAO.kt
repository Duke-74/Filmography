package com.example.mobile1.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mobile1.model.Movie

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addMovie(movie: Movie)

    @Query("SELECT * FROM MovieDatabase ORDER BY movie_id ASC")
    fun getMovies(): LiveData<List<Movie>>
}