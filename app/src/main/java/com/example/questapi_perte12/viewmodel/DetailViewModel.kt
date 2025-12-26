package com.example.questapi_perte12.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.questapi_perte12.modeldata.DataSiswa
import com.example.questapi_perte12.repositori.RepositoryDataSiswa
import com.example.questapi_perte12.uicontroller.route.DestanasiDetail
import kotlinx.coroutines.launch

sealed interface DetailUiState {
    data class Success(val siswa: DataSiswa) : DetailUiState
    object Error : DetailUiState
    object Loading : DetailUiState
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryDataSiswa: RepositoryDataSiswa
) : ViewModel() {

    var detailUiState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set

    private val _idSiswa: Int = checkNotNull(savedStateHandle[DestanasiDetail.itemIdArg])

    init {
        getSiswaById()
    }

    fun getSiswaById() {
        viewModelScope.launch {
            detailUiState = DetailUiState.Loading
            detailUiState = try {
                val siswa = repositoryDataSiswa.getSiswaById(_idSiswa)
                DetailUiState.Success(siswa)
            } catch (e: Exception) {
                DetailUiState.Error
            }
        }
    }

