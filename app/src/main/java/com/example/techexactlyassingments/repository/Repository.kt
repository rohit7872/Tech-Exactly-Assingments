package com.example.techexactlyassingments.repository

import com.example.techexactlyassingments.model.APIResult
import com.example.techexactlyassingments.model.ApiError
import com.example.techexactlyassingments.networking.retrofit.RetrofitInstance
import com.example.techexactlyassingments.model.ApiResponse

class Repository {
    suspend fun getAppListByKidId(kidId: Int): APIResult<ApiResponse> {
        return try {
            val response = RetrofitInstance.apiService.getDataList(kidId)
            if (response.isSuccessful) {
                APIResult(
                    data = response.body()
                )
            } else {
                APIResult(
                    error = ApiError(
                        code = response.code(),
                        message = response.message(),
                        exception = Exception("Something went wrong")
                    )
                )
            }

        } catch (e: Exception) {
            APIResult(
                error = ApiError(
                    code = -1,
                    message = e.localizedMessage,
                    exception = e
                )
            )
        }
    }
}



