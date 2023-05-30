package com.example.practica3danp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practica3danp.AlumnoPackage.AlumnoViewModel
import com.example.practica3danp.CursoPackage.CursoViewModel
import com.example.practica3danp.ui.theme.Practica3DANPTheme
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica3DANPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val context = LocalContext.current

                    val repository = Repository(AppDatabase.getInstance(context.applicationContext))
                    val alumnoViewModel = AlumnoViewModel(repository)
                    val curosViewModel = CursoViewModel(repository)
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main_page", builder = {
                        composable("alumno_page") { AlumnoScreen(alumnoViewModel,navController) }
                        composable("curso_page") { CursoScreen(curosViewModel,navController) }
                        composable("main_page") { Greeting(repository,navController) }

                    })



                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Greeting(repository: Repository, navController: NavController) {
    val TAG: String = "RoomDatabase"
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        val studentsOnClick: () -> Unit = {
            scope.launch {
                repository.getAllAlumnos().collectLatest{
                    Log.d(TAG, it.toString())
                }
            }
        }

        val booksOnClick: () -> Unit = {
            scope.launch {
                repository.getAllCursos().collectLatest {
                    Log.d(TAG, it.toString())
                }
            }
        }

        Button(onClick = studentsOnClick) {
            Text(text = "Show students")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = booksOnClick) {
            Text(text = "Show books")
        }



        Scaffold(

            content = {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Menu", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)

                    Button(
                        onClick = {  navController.navigate("curso_page")},
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text("Registrar Curso")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                                  navController.navigate("alumno_page")
                        },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text("Registrar Alumno")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text("Mostror Cursos con Almunos")
                    }

                    Spacer(modifier = Modifier.height(16.dp))


                }
            }
        )
    }
}


