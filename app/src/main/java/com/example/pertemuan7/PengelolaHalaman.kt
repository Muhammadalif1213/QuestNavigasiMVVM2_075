package com.example.pertemuan7

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan7.ui.viewmodel.MahasiswaViewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pertemuan7.model.JenisKelamin
import com.example.pertemuan7.ui.view.FormMahasiswa
import androidx.compose.ui.platform.LocalContext
import com.example.pertemuan7.ui.view.DetailMahasiswaView

enum class Halaman{
    Formulir,
    Detail
}

@Composable
fun Pengelolahalaman(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MahasiswaViewModel = viewModel()
){
    val StateUI by viewModel.uiState.collectAsState()
    NavHost(navController = navController, startDestination = Halaman.Formulir.name){
        composable(route = Halaman.Formulir.name){
            val konteks = LocalContext.current
            FormMahasiswa(
                modifier = Modifier,
                listJk = JenisKelamin.listJK.map{
                        id -> konteks.resources.getString(id)
                },
                onSubmitClicked = {
                    viewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.Detail.name)
                }
            )
        }
        composable(route = Halaman.Detail.name){
            DetailMahasiswaView(
                modifier = Modifier,
                uiStateMahasiswa = StateUI,
            )
        }

    }
}