package com.example.practica3danp

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "alumno")
data class Alumno (

    @PrimaryKey(autoGenerate = true)
    val AlumnoId : Int,
    val AlumnoNombre: String

    )

