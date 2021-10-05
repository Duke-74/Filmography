package com.example.mobile1.view

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.mobile1.R
import com.example.mobile1.model.Director
import com.example.mobile1.model.Movie
import com.example.mobile1.viewModel.MovieViewModel

class AddMovie : AppCompatActivity() {
    private lateinit var mMovieViewModel: MovieViewModel
    val TAG = "MyActivity"
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        val saveButton = findViewById<Button>(R.id.saveButton)

        if(::mMovieViewModel.isInitialized) {
            mMovieViewModel = ViewModelProvider(this).get(mMovieViewModel::class.java)

            Log.i(TAG, "Совершён переход на activity AddMovie")

            saveButton.setOnClickListener {
                saveMovie()
            }
        }
    }

    private fun saveMovie() {
        val movieName = findViewById<EditText>(R.id.movie_name_field).text.toString()
        val movieDescription = findViewById<EditText>(R.id.movie_description_field).text.toString()
        //val directorName = findViewById<EditText>(R.id.director_name_field).text.toString()
        //val directorSurname = findViewById<EditText>(R.id.director_surname_field).text.toString()

        Log.i(TAG, "Найдены все элементы")

        val movie = Movie(0, movieName, movieDescription)
        //val director = Director(0, directorName, directorSurname)

        Log.i(TAG, "Фильм создан")

        println(movie)
        //println(director)
        mMovieViewModel.addMovie(movie)

        Log.i(TAG, "Фильм добавлен")

        Toast.makeText(this, "Фильм добавлен в список", Toast.LENGTH_LONG).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}