package com.cleantool.indiacleantool.appmodules.servicebooking

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleantool.indiacleantool.appmodules.servicebooking.data.BookServiceRepository
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.models.networkmodels.servicerequest.ServiceRequest
import com.cleantool.indiacleantool.models.networkmodels.commosn.NetworkResultWrapper
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.ServiceProviderCompanyDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class BookServiceViewModal : ViewModel() {

     @Inject lateinit var bookServiceRepository: BookServiceRepository


     init {
          ServiceIndiaApplication.getApplicationComponent().inject(this)
     }

     val statusLiveData = MutableLiveData<Status>()

     lateinit var serviceProviderCompanyDetail: ServiceProviderCompanyDetail
     lateinit var serviceRequest: ServiceRequest
     var serviceCode:String = ""


     fun submitServiceRequest() = viewModelScope.launch(Dispatchers.IO) {

          statusLiveData.postValue(Status(SHOW_LOADER,"Saving..."))
          val response = bookServiceRepository.booksService(serviceRequest)
          when(response){

               is NetworkResultWrapper.Success -> {
                    val serviceResponse = response.value
                    serviceRequest.serviceReqCode=serviceResponse.serviceReqCode
                    serviceRequest.time=serviceResponse.time
                    serviceRequest.companyName=serviceProviderCompanyDetail.company.companyName
                    statusLiveData.postValue(Status(MOVE_TO_CONFIRMATION,serviceRequest))
               }

               is NetworkResultWrapper.GenericError -> {
                    statusLiveData.postValue(Status(ERROR,"Error while posting"))
               }

               is NetworkResultWrapper.NetworkError -> {
                    statusLiveData.postValue(Status(ERROR,"Network Error"))
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
          val MOVE_TO_CONFIRMATION=6
     }
}