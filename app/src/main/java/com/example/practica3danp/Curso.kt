package com.example.practica3danp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "curso")
data class Curso (
    @PrimaryKey(autoGenerate = true)
    val CursoId : Int,
    val CursoNombre: String
        )


