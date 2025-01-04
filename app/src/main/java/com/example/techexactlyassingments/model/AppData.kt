package com.example.techexactlyassingments.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AppData(
    @SerializedName("app_list") val app_list: List<ApplicationsModel>?,
    @SerializedName("usage_access") val usage_access: Int
) : Parcelable



