package com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidercompanylist

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleantool.indiacleantool.appmodules.serviceprovider.data.ServiceProviderCompanyRespository
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.models.networkmodels.commosn.NetworkResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ServiceProviderCompanyListViewModal : ViewModel() {

    init {
        ServiceIndiaApplication.getApplicationComponent().inject(this)
    }

    @Inject
    lateinit var serviceProviderCompanyRespository: ServiceProviderCompanyRespository
    val statusLiveData = MutableLiveData<Status>()


    fun getServiceProvideCompanyDetails(service_code:String){

        statusLiveData.postValue(
            Status(SHOW_LOADER,null )
        )
        viewModelScope.launch(Dispatchers.Default) {

            val networkResponse = serviceProviderCompanyRespository.getServiceProviderCompanyDetails(service_code)

            when(networkResponse){

                is NetworkResultWrapper.Success -> {

                    val serviceProviderResponse = networkResponse.value
                    if(serviceProviderResponse.error!=null && !TextUtils.isEmpty(serviceProviderResponse.error.errormsg)){
                        statusLiveData.postValue(
                            Status(ERROR, serviceProviderResponse.error.errormsg)
                        )
                    }else{
                        val listCompanyDetails = serviceProviderResponse.serviceProviderCompanyDetails
                        statusLiveData.postValue(
                            Status(SUCCESS,listCompanyDetails )
                        )
                    }
                }

                is NetworkResultWrapper.NetworkError -> {
                    statusLiveData.postValue(
                        Status(HIDE_LOADER,null )
                    )
                    statusLiveData.postValue(
                        Status(ERROR,"Network Error")
                    )
                }

                is NetworkResultWrapper.GenericError -> {
                    statusLiveData.postValue(
                        Status( HIDE_LOADER,null )
                    )
                    statusLiveData.postValue(
                        Status(ERROR,"Error while fetching data." )
                    )
                }
            }
        }
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