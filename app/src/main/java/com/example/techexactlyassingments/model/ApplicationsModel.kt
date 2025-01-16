package com.example.techexactlyassingments.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApplicationsModel(
    @SerializedName("app_id") val app_id: Int,
    @SerializedName("fk_kid_id") val fk_kid_id: Int,
    @SerializedName("kid_profile_image") val kid_profile_image: String,
    @SerializedName("app_name") val app_name: String,
    @SerializedName("app_icon") val app_icon: String,
    @SerializedName("app_package_name") val app_package_name: String,
    @SerializedName("status") var status: String,
    var isSwitchOn: Boolean
) : Parcelable
