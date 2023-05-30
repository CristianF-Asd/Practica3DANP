package com.example.practica3danp.AlumnoPackage

import com.example.practica3danp.Alumno

data class AlumnoState (
    val alumnos: List<Alumno> = emptyList(),
    val alumnoId : Int=0,
    val alumnoNombre: String = ""
)
