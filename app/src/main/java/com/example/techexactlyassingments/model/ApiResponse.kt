package com.example.techexactlyassingments.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: AppData?,
    @SerializedName("message") val message: String
) : Parcelable
