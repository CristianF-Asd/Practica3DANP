package com.example.practica3danp

import androidx.room.Entity

@Entity(primaryKeys = ["AlumnoId", "CursoId"])
data class AlumnoCursoCrossRef (
    val AlumnoId: Int,
    val CursoId: Int
    )
