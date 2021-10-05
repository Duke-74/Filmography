package com.example.mobile1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mobile1.DAO.MovieDAO
import com.example.mobile1.DAO.DirectorDAO
import com.example.mobile1.model.Movie
import com.example.mobile1.model.Director

@Database(entities = [Movie::class, Director::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun movieDAO(): MovieDAO
    abstract fun directorDAO(): DirectorDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance

                return instance
            }
        }
    }
}