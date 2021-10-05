package com.example.mobile1.model

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DirectorDatabase")
data class Director(
    @PrimaryKey(autoGenerate = true)
    val director_id: Int,
    val directorName: String,
    val directorSurname: String
)