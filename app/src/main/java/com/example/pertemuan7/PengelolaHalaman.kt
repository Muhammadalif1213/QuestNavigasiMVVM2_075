package com.example.pertemuan7

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan7.ui.viewmodel.MahasiswaViewModel

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

}