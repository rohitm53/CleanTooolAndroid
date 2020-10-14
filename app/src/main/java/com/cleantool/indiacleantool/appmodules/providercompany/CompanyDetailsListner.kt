package com.cleantool.indiacleantool.appmodules.providercompany

import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.TimeSlot

interface CompanyDetailsListner {

    fun onReadRequiredPerson(num:Int)
    fun onTimeSlotsSelected(timeSlot: TimeSlot)
}