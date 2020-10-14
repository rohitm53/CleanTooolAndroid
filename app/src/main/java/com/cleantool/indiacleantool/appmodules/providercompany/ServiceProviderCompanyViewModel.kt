package com.cleantool.indiacleantool.appmodules.providercompany

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.models.networkmodels.commosn.NetworkResultWrapper
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.TimeSlot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ServiceProviderCompanyViewModel : ViewModel(){


    init {
        ServiceIndiaApplication.getApplicationComponent().inject(this)
    }


    @Inject lateinit var serviceProviderCompanyRespository: ServiceProviderCompanyRespository
    val statusLiveData = MutableLiveData<Status>()

    var requiredPerson : Int=-1


    fun getServiceProvideCompanyDetails(service_code:String){

        viewModelScope.launch(Dispatchers.Default) {

            val networkResponse = serviceProviderCompanyRespository.getServiceProviderCompanyDetails(service_code)

            when(networkResponse){

                is NetworkResultWrapper.Success -> {

                    val serviceProviderResponse = networkResponse.value
                    if(serviceProviderResponse.error!=null && !TextUtils.isEmpty(serviceProviderResponse.error.errormsg)){
                        statusLiveData.postValue(Status(ERROR,serviceProviderResponse.error.errormsg))
                    }else{
                        val listCompanyDetails = serviceProviderResponse.serviceProviderCompanyDetails
                        statusLiveData.postValue(Status(SUCCESS,listCompanyDetails))
                    }
                }

                is NetworkResultWrapper.NetworkError -> {
                    Log.d("rohitclean", "Network Error")
                    statusLiveData.postValue(Status(HIDE_LOADER,  null ))
                    statusLiveData.postValue(Status( ERROR,"Error while loggin in") )
                }

                is NetworkResultWrapper.GenericError -> {
                    Log.d("rohitclean", "Generic Error : ${networkResponse}")
                    statusLiveData.postValue(Status(HIDE_LOADER, null) )
                    statusLiveData.postValue(Status(ERROR,  "Error while loggin in" ))
                }
            }
        }
    }

    fun onReadRequiredPerson(num: Int) {
    }

    fun onTimeSlotsSelected(timeSlot: TimeSlot) {
    }



    //  Status Management
    data class Status(val status:Int,val data:Any?)

    companion object  {
        val SUCCESS = 1
        val ERROR = 2
        val SHOW_LOADER = 3
        val HIDE_LOADER = 4
        val SHOW_TOAST=5
    }

}