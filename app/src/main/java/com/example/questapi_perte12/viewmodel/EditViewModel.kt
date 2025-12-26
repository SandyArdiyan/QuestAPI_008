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

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    suspend fun updateSiswa() {
        if (validasiInput(uiStateSiswa.detailSiswa)) {
            try {
                repositoryDataSiswa.updateSiswa(_idSiswa, uiStateSiswa.detailSiswa.toDataSiswa())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}