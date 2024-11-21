package com.example.pertemuan7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pertemuan7.model.DataMahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {

    //request
    private val _uistate = MutableStateFlow(DataMahasiswa())
    val uiState: StateFlow<DataMahasiswa> = _uistate.asStateFlow()

    fun saveDataMahasiswa(listDM:List<String>){
        _uistate.update { dataMhs ->
            dataMhs.copy(
                nama = listDM[0],
                NIM = listDM[1],
                gender = listDM[3],
                alamat = listDM[4],
                email = listDM[5],
                noHp = listDM[6]
            )
        }
    }
}