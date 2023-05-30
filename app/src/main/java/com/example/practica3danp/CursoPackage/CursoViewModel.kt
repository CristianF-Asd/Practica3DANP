package com.example.practica3danp.CursoPackage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica3danp.Alumno
import com.example.practica3danp.AlumnoPackage.AlumnoState
import com.example.practica3danp.Curso
import com.example.practica3danp.Repository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CursoViewModel  (private val repository: Repository): ViewModel() {


    var state by mutableStateOf(CursoState())
        private set

    init{
        viewModelScope.launch {
            repository.getAllCursos().collectLatest {
                state = state.copy(
                    cursos = it
                )
            }
        }
    }

    fun changeName(name: String){
        state = state.copy(
            cursoNombre = name
        )
    }

    fun deleteCurso(curso: Curso){
        viewModelScope.launch {
            repository.deleteCurso(curso)
        }
    }
    fun editCurso(curso: Curso){
        state = state.copy(
            cursoNombre = curso.CursoNombre


            )

    }

    fun createCurso(){
        val curso=Curso(
            state.cursoId,
            state.cursoNombre
        )
        viewModelScope.launch {
            repository.insertCurso(curso)
        }
        state = state.copy(
            cursoNombre = "",

            )
    }
}