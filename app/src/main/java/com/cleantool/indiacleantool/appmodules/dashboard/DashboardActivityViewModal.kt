package com.cleantool.indiacleantool.appmodules.dashboard

import androidx.lifecycle.ViewModel
import com.cleantool.indiacleantool.common.Constants
import com.cleantool.indiacleantool.common.StaticDataProvider
import com.cleantool.indiacleantool.models.services.Service

class DashboardActivityViewModal : ViewModel() {

    lateinit var hmServices : HashMap<String,List<Service>>

    init {
        hmServices = HashMap()
        hmServices.put(Constants.House_Hold_Type,StaticDataProvider.getServiceDataByType(Constants.House_Hold_Type))
        hmServices.put(Constants.Commercial_Type,StaticDataProvider.getServiceDataByType(Constants.Commercial_Type))
        hmServices.put(Constants.Laundary_Type,StaticDataProvider.getServiceDataByType(Constants.Laundary_Type))
    }

}