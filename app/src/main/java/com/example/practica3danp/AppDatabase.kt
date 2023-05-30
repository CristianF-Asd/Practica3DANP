package com.example.practica3danp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Alumno::class, Curso::class, AlumnoCursoCrossRef::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun alumnoDao(): AlumnoDao
    abstract fun cursoDao(): CursoDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "database-a"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance

                }

                return instance
            }
        }
    }
}