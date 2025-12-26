package com.example.questapi_perte12.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.questapi_perte12.repositori.AplikasiDataSiswa
import com.example.questapi_perte12.viewmodel.DetailViewModel
import com.example.questapi_perte12.viewmodel.EditViewModel
import com.example.questapi_perte12.viewmodel.EntryViewModel
import com.example.questapi_perte12.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiDataSiswa().container.repositoryDataSiswa)
        }

        initializer {
            EntryViewModel(aplikasiDataSiswa().container.repositoryDataSiswa)
        }

        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                aplikasiDataSiswa().container.repositoryDataSiswa
            )
        }

        initializer {
            EditViewModel(
                createSavedStateHandle(),
                aplikasiDataSiswa().container.repositoryDataSiswa
            )
        }
    }
}

/**
 * Extension function untuk query aplikasi object dan mengembalikan instance dari AplikasiDataSiswa
 */
fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiDataSiswa)