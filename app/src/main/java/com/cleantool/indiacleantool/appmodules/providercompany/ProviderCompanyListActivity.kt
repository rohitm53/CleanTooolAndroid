package com.cleantool.indiacleantool.appmodules.providercompany

import android.Manifest
import android.content.pm.PackageManager
import android.content.res.Resources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.models.providingcompany.ProvidingCompanyTimeSlotsDetails
import com.cleantool.indiacleantool.models.providingcompany.TimeSlots
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_provider_company_list_activity.*
import kotlinx.android.synthetic.main.base_activity.*
import java.time.LocalDateTime


class ProviderCompanyListActivity : BaseActivity() , OnMapReadyCallback , CapturePersonReqListner {

    private lateinit var listProvidingCompany : List<ProvidingCompanyTimeSlotsDetails>
    private  var googleMap: GoogleMap?=null
    private lateinit var  snackbar: Snackbar


    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_provider_company_list_activity,ll_body,true)
        setMapFrameHeight()
        listProvidingCompany = loadData()
        vp_company.adapter = CompanyPagerAdapter(this,listProvidingCompany)

        vp_company.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                zoomMaptoCompanyLocation(position)
            }
        })
        val mapFragment = supportFragmentManager.findFragmentById(R.id.fr_google_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun setMapFrameHeight(){
        val screenHeight= Resources.getSystem().displayMetrics.heightPixels
        val mapHeight = ((screenHeight*30)/100)
        frameLayout.layoutParams= ConstraintLayout.LayoutParams(0,mapHeight)
    }

    private fun loadData() : List<ProvidingCompanyTimeSlotsDetails>{

        val listProvidingCompany = ArrayList<ProvidingCompanyTimeSlotsDetails>()
        var startTime = LocalDateTime.now()
        var endTime = LocalDateTime.now().plusHours(1)

        for(j in 1..10){
            val companyTimeSlots = ArrayList<TimeSlots>()
            for (i in 1..10){
                val timeSlots = TimeSlots(startTime,endTime, LocalDateTime.now(),10)
                companyTimeSlots.add(timeSlots)

                startTime = startTime.plusHours(1)
                endTime = endTime.plusHours(1)
            }
            val providingCompany = ProvidingCompanyTimeSlotsDetails(j,"Company_"+j,companyTimeSlots)
            if(j==1){
                providingCompany.latitude=17.4875
                providingCompany.longitude=78.3953
            }else if(j==2){
                providingCompany.latitude=17.5197
                providingCompany.longitude=78.3779
            }else if(j==3){
                providingCompany.latitude=17.4837
                providingCompany.longitude=78.3158
            }else if(j==4){
                providingCompany.latitude=17.4834
                providingCompany.longitude=78.3871
            }else if(j==5){
                providingCompany.latitude=17.4814
                providingCompany.longitude=78.4490
            }else if(j==6){
                providingCompany.latitude=17.4659
                providingCompany.longitude=78.4601
            }else if(j==7){
                providingCompany.latitude=17.4686
                providingCompany.longitude=78.4811
            }else if(j==8){
                providingCompany.latitude=17.5169
                providingCompany.longitude=78.3428
            }else if(j==9){
                providingCompany.latitude=17.5066
                providingCompany.longitude=78.4112
            }else if(j==10  ){
                providingCompany.latitude=17.4933
                providingCompany.longitude=78.3914
            }
            listProvidingCompany.add(providingCompany)
        }
        return listProvidingCompany
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
        addMarker()
    }

    private fun addMarker(){
        showLoader("Intialising map...")
        if(listProvidingCompany.size>0){
            for(company in listProvidingCompany){
                val location = LatLng(company.latitude,company.longitude)
                val marker = googleMap?.addMarker(MarkerOptions()
                                                    .position(location)
                                                    .title(""+company.companyName))
                marker?.showInfoWindow()
            }
            zoomMaptoCompanyLocation(0)
        }
        hideLoader()
    }

    fun zoomMaptoCompanyLocation(position: Int){
        val coordinate = LatLng(listProvidingCompany[position].latitude, listProvidingCompany[position].longitude)
        val zoomLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 15f)
        googleMap?.animateCamera(zoomLocation)
    }

    class CompanyPagerAdapter : FragmentStateAdapter{

        private var  listprovidingCompanyTimeSlots: List<ProvidingCompanyTimeSlotsDetails>
        private var capturePersonReqListner: CapturePersonReqListner

        constructor(fragmentActivity: FragmentActivity,listprovidingCompanyTimeSlots: List<ProvidingCompanyTimeSlotsDetails>): super(fragmentActivity){
            this.listprovidingCompanyTimeSlots=listprovidingCompanyTimeSlots
            this.capturePersonReqListner = fragmentActivity as CapturePersonReqListner
        }

        override fun getItemCount(): Int {
            if(listprovidingCompanyTimeSlots.size>0){
                return listprovidingCompanyTimeSlots.size
            }else{
                return 0
            }
        }

        override fun createFragment(position: Int): Fragment {
            return ProviderCompanyFragment(listprovidingCompanyTimeSlots[position],capturePersonReqListner)
        }
    }

    override fun openSnackBar() {
        val num = 0
        snackbar = Snackbar.make(ll_body,"Person req"+num,Snackbar.LENGTH_LONG)
        snackbar.show()
    }

    override fun onPersonNumAdded(strNum: String) {

    }

}