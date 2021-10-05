package com.example.mobile1.model

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MovieDatabase")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val movie_id: Int,
    val movieName: String,
    val movieDescription: String
)