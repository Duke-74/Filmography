package com.example.mobile1.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mobile1.model.Director

@Dao
interface DirectorDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addDirector(director: Director)

    @Query("SELECT * FROM DirectorDatabase ORDER BY director_id ASC")
    fun getDirectors(): LiveData<List<Director>>
}