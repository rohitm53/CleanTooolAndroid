package com.cleantool.indiacleantool.models.networkmodels.servicerequest


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class ServiceRequest(

    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    var companyCode: String = "",
    var mobileUserCode: String = "",
    var serviceCode: String = "",
    var serviceMsgId: String = "",
    var timeSlotCode: String = "",
    var serviceReqCode: String? = null,  //Need to get by Response only


    //only App side , Need to get by Response only

    var companyName: String? = null,
    var scheduled: String? = null,
    var serviceName: String? = null,
    val assignedEmployeeMobile: String? = null,
    val assignedEmployeeName: String? = null,
    val statusCode: Int? = null,
    val statusName: String? = null,

    ) : Serializable {

    object StatusCode {
        const val PENDING=100
        const val ASSIGNED=101
        const val INPROGRESS=102
        const val COMPLETED=103
        const val CANCELED=104
    }

}