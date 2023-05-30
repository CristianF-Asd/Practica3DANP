package com.example.practica3danp

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CursoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurso(curso: Curso)

    @Query("SELECT * FROM curso")
    fun getAllCurso(): Flow<List<Curso>>

    @Delete
    suspend fun deleteCurso(curso: Curso)

    @Transaction
    @Query("SELECT * FROM curso")
    fun getCursosWithAlumnos(): List<Cursos_Alumnos>
}