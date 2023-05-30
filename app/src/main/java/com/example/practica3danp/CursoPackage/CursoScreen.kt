package com.example.practica3danp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practica3danp.AlumnoPackage.AlumnoItem
import com.example.practica3danp.AlumnoPackage.AlumnoViewModel
import com.example.practica3danp.CursoPackage.CursoItem
import com.example.practica3danp.CursoPackage.CursoViewModel

@Composable
fun CursoScreen(viewModel : CursoViewModel, navController: NavController) {

    val state = viewModel.state
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Cursos", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)

        TextField(
            value = state.cursoNombre,
            onValueChange = { viewModel.changeName(it) },
            placeholder = { Text(text = "Nombre del Curso") }
        )


        Button(onClick = { viewModel.createCurso() }) {
            Text(text = "Agregar Curso")
        }


        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(state.cursos) {
                CursoItem(curso=it, modifier = Modifier.fillMaxWidth(),
                    onEdit= {
                        viewModel.editCurso(it)
                    }, onDelete= {
                        viewModel.deleteCurso(it);
                    })


            }
        }
    }

}