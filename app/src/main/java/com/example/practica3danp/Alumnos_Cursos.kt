package com.example.practica3danp

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class Alumnos_Cursos (
    @Embedded val alumno: Alumno,
    @Relation(
        parentColumn = "AlumnoId",
        entityColumn = "CursoId",
        associateBy = Junction(AlumnoCursoCrossRef::class)
    )
    val cursos: List<Curso>
    )


