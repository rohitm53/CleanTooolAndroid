package com.cleantool.indiacleantool.models.providingcompany

import java.time.LocalDateTime

data class ProvidingCompanyTimeSlotsDetails (
    var id:Int=0,
    var companyName:String="",
    var timeSlots : List<TimeSlots>,
    var latitude : Double=0.0,
    var longitude : Double=0.0
)

data class TimeSlots(
    var startTime: LocalDateTime? = null,
    var endTime: LocalDateTime? = null,
    var date:LocalDateTime?=null,
    var availablePersons:Int=0,
    var isSelected:Boolean=false
)
