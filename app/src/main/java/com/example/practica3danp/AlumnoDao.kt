package com.example.practica3danp

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AlumnoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlumno(alumno: Alumno)

    @Query("SELECT * FROM alumno")
    fun getAllAlumno(): Flow<List<Alumno>>

    @Delete
    suspend fun deleteAlumno(alumno: Alumno)

    @Transaction
    @Query("SELECT * FROM alumno")
    fun getAlumnosWithCursos(): Flow<List<Alumnos_Cursos>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAlumnoCursoCrossRef(alumnoCursoCrossRef: AlumnoCursoCrossRef)




}