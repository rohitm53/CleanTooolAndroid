package com.cleantool.indiacleantool.appmodules.dashboard.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.servicebooking.BookServiceViewModal
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.models.networkmodels.commosn.NetworkResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DashboardHistoryViewModal : ViewModel() {

    @Inject lateinit var dashboardHistoryRepository : DashboardHistoryRepository

    init {
          ServiceIndiaApplication.getApplicationComponent().inject(this)
    }


    val statusLiveData = MutableLiveData<Status>()

    fun getAllPendingServiceRequest(){

        viewModelScope.launch(Dispatchers.IO) {
            statusLiveData.postValue(Status(SHOW_LOADER,"Fetching..."))

            val networkResponse = dashboardHistoryRepository.getAllServiceRequest()

            when (networkResponse){

                is NetworkResultWrapper.Success -> {
                    statusLiveData.postValue(Status(SERVICE_REQUEST_FETCHED,networkResponse.value))
                }

                is NetworkResultWrapper.NetworkError -> {
                    statusLiveData.postValue(Status(ERROR,ServiceIndiaApplication.getServiceIndiaApplication().getString(R.string.network_issue)))
                }

                is NetworkResultWrapper.GenericError -> {
                    statusLiveData.postValue(Status(ERROR,ServiceIndiaApplication.getServiceIndiaApplication().getString(R.string.error_while_fetching_records)))
                }
            }
        }
    }

    //  Status Management
    data class Status (val status: Int,val data: Any? )

     companion object  {
        val SERVICE_REQUEST_FETCHED = 1
        val ERROR = 2
        val SHOW_LOADER = 3
        val HIDE_LOADER = 4
        val SHOW_TOAST=5
        val NAVIGATE_TO_SIGNUP=6
    }
}