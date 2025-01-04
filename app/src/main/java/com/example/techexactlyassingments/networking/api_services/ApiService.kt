package com.example.techexactlyassingments.networking.api_services

import com.example.techexactlyassingments.model.ApiResponse
import com.example.techexactlyassingments.model.AppData
import com.example.techexactlyassingments.model.ApplicationsModel
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {
    @POST("apps/list")
    suspend fun getDataList(
        @Query("kid_id") kidId: Int
    ): Response<ApiResponse>
}