package com.cleantool.indiacleantool.appmodules.serviceprovider.listner

import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.TimeSlot

interface CompanyDetailsListner {

    fun onTimeSlotsSelected(timeSlot: TimeSlot)

}