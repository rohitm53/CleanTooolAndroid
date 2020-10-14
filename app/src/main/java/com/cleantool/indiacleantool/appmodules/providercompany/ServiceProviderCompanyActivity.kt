package com.cleantool.indiacleantool.appmodules.providercompany

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import androidx.lifecycle.observe
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.confirmationscreen.ConfirmationScreenActivity
import com.cleantool.indiacleantool.common.IntentKey
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.ServiceProviderCompanyDetail
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.TimeSlot
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_service_provider_company.*
import kotlinx.android.synthetic.main.base_activity.*


class ServiceProviderCompanyActivity : BaseActivity() ,CompanyDetailsListner, OnMapReadyCallback  {

    private lateinit var viewModel: ServiceProviderCompanyViewModel
    private lateinit var serviceProviderCompanyDetails: List<ServiceProviderCompanyDetail>
    private  var googleMap: GoogleMap?=null

    private lateinit var service_code:String

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_service_provider_company,ll_body,true)
        setMapFrameHeight()

        service_code = intent.getStringExtra(IntentKey.Service_Code)!!

        viewModel = ViewModelProvider(this).get(ServiceProviderCompanyViewModel::class.java)



        vp_company.apply {
            adapter = CompanyPagerAdapter(this@ServiceProviderCompanyActivity,ArrayList())
        }

        vp_company.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                zoomMaptoCompanyLocation(position)
            }
        })
        val mapFragment = supportFragmentManager.findFragmentById(R.id.fr_google_map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        viewModel.getServiceProvideCompanyDetails(service_code)

        viewModel.statusLiveData.observe<ServiceProviderCompanyViewModel.Status>(this,{

            when(it.status){
                ServiceProviderCompanyViewModel.SUCCESS -> {
                    serviceProviderCompanyDetails= it.data as List<ServiceProviderCompanyDetail>
                    addMarker()
                    (vp_company.adapter as CompanyPagerAdapter).refresh(serviceProviderCompanyDetails)
                }

                ServiceProviderCompanyViewModel.ERROR -> {
                    showToast("error")
                }
            }
        })

        btn_continue.setOnClickListener {
            val intent  = Intent(this,ConfirmationScreenActivity::class.java)
            startActivity(intent)
        }
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
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        googleMap?.isMyLocationEnabled=true
    }

    private fun addMarker(){
        showLoader("Intialising map...")
        if(serviceProviderCompanyDetails.size>0){
            for(serviceProvider in serviceProviderCompanyDetails){
                val location = LatLng(serviceProvider.company.latitude,serviceProvider.company.longitude)
                val marker = googleMap?.addMarker(MarkerOptions()
                                                    .position(location)
                                                    .title(""+serviceProvider.company.companyName))
                marker?.showInfoWindow()
            }
            zoomMaptoCompanyLocation(0)
        }
        hideLoader()
    }

    fun zoomMaptoCompanyLocation(position: Int){
        val coordinate = LatLng(serviceProviderCompanyDetails[position].company.latitude, serviceProviderCompanyDetails[position].company.longitude)
        val zoomLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 15f)
        googleMap?.animateCamera(zoomLocation)
    }

    class CompanyPagerAdapter(
        private var fragmentActivity: FragmentActivity,
        private var serviceProviderCompanyDetails: List<ServiceProviderCompanyDetail>
    ) : FragmentStateAdapter(fragmentActivity) {

        override fun getItemCount(): Int {
            if(serviceProviderCompanyDetails.size>0){
                return serviceProviderCompanyDetails.size
            }else{
                return 0
            }
        }

        override fun createFragment(position: Int): Fragment {
            val companyDetailsListner = fragmentActivity as CompanyDetailsListner
            return ServiceProviderCompanyFragment(serviceProviderCompanyDetails[position],companyDetailsListner)
        }

        fun refresh(serviceProviderCompanyDetails: List<ServiceProviderCompanyDetail>){
            this.serviceProviderCompanyDetails=serviceProviderCompanyDetails
            notifyDataSetChanged()
        }
    }

    override fun onReadRequiredPerson(num: Int) {
        viewModel.onReadRequiredPerson(num)
    }

    override fun onTimeSlotsSelected(timeSlot: TimeSlot) {
        viewModel.onTimeSlotsSelected(timeSlot)
    }

}