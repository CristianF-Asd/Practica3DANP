package com.example.practica3danp.AlumnoPackage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica3danp.Alumno
import com.example.practica3danp.Repository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*

class AlumnoViewModel(private val repository: Repository): ViewModel() {

    var state by mutableStateOf(AlumnoState())
        private set

    init{
        viewModelScope.launch {
            repository.getAllAlumnos().collectLatest {
                state = state.copy(
                    alumnos = it
                )
            }
        }
    }

    fun changeName(name: String){
        state = state.copy(
            alumnoNombre = name
        )
    }

    fun deleteAlumno(alumno: Alumno){
        viewModelScope.launch {
            repository.deleteAlumno(alumno)
        }
    }
    fun editAlumno(alumno: Alumno){
        state = state.copy(
            alumnoNombre = alumno.AlumnoNombre,


        )

    }

    fun createAlumno(){
        val alumno = Alumno(
            state.alumnoId,
            state.alumnoNombre
        )
        viewModelScope.launch {
            repository.insertAlumno(alumno)
        }
        state = state.copy(
            alumnoNombre = "",

        )
    }

}