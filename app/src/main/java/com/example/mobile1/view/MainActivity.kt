package com.example.mobile1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mobile1.R
import android.util.Log

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TAG = "MyActivity"
        val movieListButton = findViewById<Button>(R.id.movieListButton)
        val addMovieButton = findViewById<Button>(R.id.addMovieButton)
        Log.i(TAG, "Начата работа Main activity")

        movieListButton.setOnClickListener {
            val intent = Intent(this, MovieList::class.java)
            Log.i(TAG, "Создан Intent MovieList")
            startActivity(intent)
        }

        addMovieButton.setOnClickListener {
            val intent = Intent(this, AddMovie::class.java)
            Log.i(TAG, "Создан Intent AddMovie")
            startActivity(intent)
        }
    }
}