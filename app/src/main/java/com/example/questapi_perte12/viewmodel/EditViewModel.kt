package com.example.questapi_perte12.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.questapi_perte12.modeldata.DetailSiswa
import com.example.questapi_perte12.modeldata.UIStateSiswa
import com.example.questapi_perte12.modeldata.toDataSiswa
import com.example.questapi_perte12.modeldata.toUiStateSiswa
import com.example.questapi_perte12.repositori.RepositoryDataSiswa
import com.example.questapi_perte12.uicontroller.route.DestanasiEdit
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryDataSiswa: RepositoryDataSiswa
) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private val _idSiswa: Int = checkNotNull(savedStateHandle[DestanasiEdit.itemIdArg])

    init {
        viewModelScope.launch {
            try {
                val siswa = repositoryDataSiswa.getSiswaById(_idSiswa)
                uiStateSiswa = siswa.toUiStateSiswa(true)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

