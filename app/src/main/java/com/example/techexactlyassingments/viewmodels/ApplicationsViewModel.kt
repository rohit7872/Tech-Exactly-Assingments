package com.example.techexactlyassingments.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.techexactlyassingments.model.APIResult
import com.example.techexactlyassingments.model.ApiResponse
import com.example.techexactlyassingments.model.AppData
import com.example.techexactlyassingments.model.ApplicationsModel
import com.example.techexactlyassingments.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ApplicationsViewModel(application: Application) : AndroidViewModel(application) {
    val repository = Repository()
    var obsList: MutableLiveData<APIResult<ApiResponse>> = MutableLiveData()
init {
    getApplicationList(338)
}


     fun getApplicationList(id: Int) {
        obsList.postValue(APIResult<ApiResponse>(loading = true))
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                obsList.postValue(repository.getAppListByKidId(kidId = id))
            }
        }
    }



}