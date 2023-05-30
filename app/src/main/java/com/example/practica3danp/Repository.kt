package com.example.practica3danp

import androidx.room.Query
import kotlinx.coroutines.flow.Flow

class Repository (private  val appDatabase: AppDatabase) {

    suspend fun getAllAlumnos(): Flow<List<Alumno>> {
        return appDatabase.alumnoDao().getAllAlumno()
    }
    suspend fun getAllCursos(): Flow<List<Curso>> {
        return appDatabase.cursoDao().getAllCurso()
    }
    suspend fun insertAlumno(alumno: Alumno) {
        appDatabase.alumnoDao().insertAlumno(alumno)
    }
    suspend fun insertCurso(curso: Curso) {
        appDatabase.cursoDao().insertCurso(curso)
    }

    suspend fun deleteAlumno(alumno: Alumno){
        appDatabase.alumnoDao().deleteAlumno(alumno)
    }
    suspend fun deleteCurso(curso: Curso){
        appDatabase.cursoDao().deleteCurso(curso)
    }
    suspend fun insertAlumnoCursoCrossRef(alumnoCursoCrossRef: AlumnoCursoCrossRef){
        appDatabase.alumnoDao().insertAlumnoCursoCrossRef(alumnoCursoCrossRef)
    }


    fun getAlumnosWithCursos(): Flow<List<Alumnos_Cursos>>{
        return appDatabase.alumnoDao().getAlumnosWithCursos()
    }




}