package com.example.practica3danp.CursoPackage


import com.example.practica3danp.Curso

data class CursoState (
    val cursos: List<Curso> = emptyList(),
    val cursoId : Int=0,
    val cursoNombre: String = ""
)