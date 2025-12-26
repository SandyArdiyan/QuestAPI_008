package com.example.questapi_perte12.apiservice

import com.example.questapi_perte12.modeldata.DataSiswa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ServiceApiSiswa {
    @GET("bacaTeman.php")
    suspend fun getSiswa(): List<DataSiswa>

    // PERBAIKAN: Sesuaikan dengan 'baca1teman.php'
    @GET("baca1teman.php")
    suspend fun getSiswaById(@Query("id") id: Int): DataSiswa

    @POST("insertTM.php")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa): Response<Void>

    // PERBAIKAN: Sesuaikan dengan 'editTM.php'
    @PUT("editTM.php")
    suspend fun updateSiswa(@Query("id") id: Int, @Body dataSiswa: DataSiswa): Response<Void>

    // Pastikan file ini juga ada di folder htdocs kamu, jika namanya beda ganti disini
    @DELETE("deleteTeman.php")
    suspend fun deleteSiswa(@Query("id") id: Int): Response<Void>
}