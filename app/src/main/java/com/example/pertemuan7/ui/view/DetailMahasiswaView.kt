package com.example.pertemuan7.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pertemuan7.model.DataMahasiswa

@Composable
fun DetailMahasiswaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
    onBackButtonClicked : () -> Unit
){
    val listDataMahasiswa = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("NIM", uiStateMahasiswa.NIM),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("Alamat", uiStateMahasiswa.alamat),
        Pair("email", uiStateMahasiswa.email),
        Pair("noHp",uiStateMahasiswa.noHp)

    )

    Column() {
        listDataMahasiswa.forEach { items ->
            CardSection(
            JudulParam = items.first,
            IsiParam = items.second
        ) }
        Button(onClick = {onBackButtonClicked()})
        {
            Text("Kembali")
        }
    }
}

@Composable
fun CardSection(JudulParam: String, IsiParam: String) {
    Column(horizontalAlignment = Alignment.Start) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = JudulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$IsiParam", modifier = Modifier.weight(2f))
        }
    }
}