package com.cleantool.indiacleantool.models.networkmodels.bookservice


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class ServiceRequest(

    @PrimaryKey(autoGenerate = true) var id : Int?=null,
    var companyCode: String="",
    var mobileUserCode: String="",
    var serviceCode: String="",
    var serviceMsgId: String="",
    var timeSlotCode: String="",
    var serviceReqCode:String?=null,  //Need to get by Response only

    //only App side
    var companyName:String?=null,
    var time: String?=null, //Need to get by Response only
    var serviceName: String="",

) : Serializable