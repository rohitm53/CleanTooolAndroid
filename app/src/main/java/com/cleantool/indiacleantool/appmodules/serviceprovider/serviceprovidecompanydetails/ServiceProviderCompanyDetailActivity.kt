package com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidecompanydetails

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.servicebooking.BookServiceActivity
import com.cleantool.indiacleantool.appmodules.serviceprovider.listner.CompanyDetailsListner
import com.cleantool.indiacleantool.common.IntentKey
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.Company
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.ServiceProviderCompany
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.TimeSlot
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_service_provider_company.*
import kotlinx.android.synthetic.main.base_activity.*
import java.io.Serializable


class ServiceProviderCompanyDetailActivity : BaseActivity(), CompanyDetailsListner, OnMapReadyCallback  {

    val viewModel: ServiceProviderCompanyDetailViewModel by viewModels()

    private lateinit var serviceProviderCompany: ServiceProviderCompany
    private  var googleMap: GoogleMap?=null

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_service_provider_company,ll_body,true)
        setMapFrameHeight()


        serviceProviderCompany = intent.extras?.get(IntentKey.ServiceProvideDetails) as ServiceProviderCompany
        viewModel.serviceCode = intent.getStringExtra(IntentKey.ServiceCode)!!
        viewModel.serviceType = intent.getStringExtra(IntentKey.ServiceType)!!

        viewModel.company = serviceProviderCompany.company

        viewModel.assigneServiceName()

        val mapFragment = supportFragmentManager.findFragmentById(R.id.fr_google_map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        tv_company_name.text= serviceProviderCompany.company.companyName
//        tv_company_address.text= serviceProviderCompanyDetail.company.companyName
//        tv_avail_peron.text = serviceProviderCompanyDetail.availableEmployeeCount.toString()
//
//        rv_time_slot.apply {
//            adapter = CompanyTimeSlotsAdapter(serviceProviderCompanyDetail.timeSlots,this@ServiceProviderCompanyDetailActivity)
//            layoutManager = LinearLayoutManager(this@ServiceProviderCompanyDetailActivity)
//        }
//
//        btn_continue.setOnClickListener {
//            moveToConfirmationScreen()
//        }
    }

    private fun setMapFrameHeight(){
        val screenHeight= Resources.getSystem().displayMetrics.heightPixels
        val mapHeight = ((screenHeight*30)/100)
        frameLayout.layoutParams= ConstraintLayout.LayoutParams(0,mapHeight)
    }


    override fun onMapReady(googleMap: GoogleMap?) {
        this.googleMap=googleMap


        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        googleMap?.isMyLocationEnabled=true

        addMarker(serviceProviderCompany.company)
    }

    private fun addMarker(company: Company){
        val location = LatLng(company.latitude,company.longitude)
        val marker = googleMap?.addMarker(MarkerOptions()
            .position(location)
            .title(""+company.companyName))
        marker?.showInfoWindow()


        val coordinate = LatLng(company.latitude,company.longitude)
        val zoomLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 15f)
        googleMap?.animateCamera(zoomLocation)
    }

    override fun onTimeSlotsSelected(timeSlot: TimeSlot) {
        viewModel.timeSlot=timeSlot
    }


    fun moveToConfirmationScreen(){

        if(!viewModel.isTimeSlotSelected()){
            showAlert("Please select Time slot" , {dialog,which ->
                showToast("Yes Pressed")
            },{dialog,which->
                showToast("No Pressed")
            })
        }else{
            val intent=Intent(this, BookServiceActivity::class.java).apply {
                putExtra(IntentKey.ServiceRequest,viewModel.generateServiceRequest() as Serializable)
                putExtra(IntentKey.ServiceProvideDetails,serviceProviderCompany as Serializable)
            }
            startActivity(intent)
        }

    }

}