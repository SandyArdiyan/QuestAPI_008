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

    @GET("bacaTeman.php")
    suspend fun getSiswaById(@Query("id") id: Int): DataSiswa

    @POST("insertTM.php")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa): Response<Void>

    @PUT("editTeman.php")
    suspend fun updateSiswa(@Query("id") id: Int, @Body dataSiswa: DataSiswa): Response<Void>

    @DELETE("deleteTeman.php")
    suspend fun deleteSiswa(@Query("id") id: Int): Response<Void>
}