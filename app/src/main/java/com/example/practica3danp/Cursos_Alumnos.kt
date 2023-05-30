package com.example.practica3danp

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import kotlinx.coroutines.flow.Flow

data class Cursos_Alumnos (

    @Embedded val curso: Curso,
    @Relation(
        parentColumn = "CursoId",
        entityColumn = "AlumnoId",
        associateBy = Junction(AlumnoCursoCrossRef::class)
    )
    val alumnos: List<Alumno>

    )
