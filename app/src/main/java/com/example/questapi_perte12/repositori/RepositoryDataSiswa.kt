package com.example.questapi_perte12.repositori

import com.example.questapi_perte12.apiservice.ServiceApiSiswa
import com.example.questapi_perte12.modeldata.DataSiswa
import retrofit2.Response

interface RepositoryDataSiswa {
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa): Response<Void>
    suspend fun getSiswaById(id: Int): DataSiswa
    suspend fun updateSiswa(id: Int, dataSiswa: DataSiswa): Response<Void>
    suspend fun deleteSiswa(id: Int): Response<Void>
}

class JaringanRepositoryDataSiswa(
    private val serviceApiSiswa: ServiceApiSiswa
) : RepositoryDataSiswa {
    override suspend fun getDataSiswa(): List<DataSiswa> = serviceApiSiswa.getSiswa()

    override suspend fun postDataSiswa(dataSiswa: DataSiswa): Response<Void> =
        serviceApiSiswa.postSiswa(dataSiswa)

    override suspend fun getSiswaById(id: Int): DataSiswa = serviceApiSiswa.getSiswaById(id)

    override suspend fun updateSiswa(id: Int, dataSiswa: DataSiswa): Response<Void> =
        serviceApiSiswa.updateSiswa(id, dataSiswa)

    override suspend fun deleteSiswa(id: Int): Response<Void> = serviceApiSiswa.deleteSiswa(id)
}