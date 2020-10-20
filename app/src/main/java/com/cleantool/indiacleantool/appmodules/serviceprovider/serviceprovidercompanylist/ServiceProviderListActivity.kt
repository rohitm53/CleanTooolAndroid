package com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidercompanylist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.serviceprovider.listner.ServiceProviderListner
import com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidecompanydetails.ServiceProviderCompanyDetailActivity
import com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidercompanylist.ServiceProviderCompanyListViewModal.Companion.ERROR
import com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidercompanylist.ServiceProviderCompanyListViewModal.Companion.HIDE_LOADER
import com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidercompanylist.ServiceProviderCompanyListViewModal.Companion.SHOW_LOADER
import com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidercompanylist.ServiceProviderCompanyListViewModal.Companion.SUCCESS
import com.cleantool.indiacleantool.common.IntentKey
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.ServiceProviderCompanyDetail
import kotlinx.android.synthetic.main.activity_service_provider_list.*
import kotlinx.android.synthetic.main.base_activity.*
import java.io.Serializable

class ServiceProviderListActivity : BaseActivity() , ServiceProviderListner {

    val viewModal: ServiceProviderCompanyListViewModal by viewModels()

    private var serviceCode : String=""
    private var serviceType : String=""

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_service_provider_list,ll_body,true)

        serviceCode = intent.getStringExtra(IntentKey.ServiceCode)!!
        serviceType = intent.getStringExtra(IntentKey.ServiceType)!!


        viewModal.getServiceProvideCompanyDetails(serviceCode)
        viewModal.statusLiveData.observe(this,{

            when(it.status){

                SHOW_LOADER -> {
                    showLoader("")
                }

                HIDE_LOADER -> {
                    hideLoader()
                }

               SUCCESS -> {
                   hideLoader()
                   updateList(it.data as List<ServiceProviderCompanyDetail>)
               }

                ERROR -> {
                    hideLoader()
                    showToast(it.data as String)
                }
            }
        })
    }

    private fun updateList(listServiceProvider : List<ServiceProviderCompanyDetail>){
        rv_companies.apply {
            adapter = ServiceProviderCompanyAdapter(listServiceProvider,this@ServiceProviderListActivity)
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun moveToServiceDetails(serviceProviderCompanyDetail: ServiceProviderCompanyDetail) {
        val intent = Intent(this, ServiceProviderCompanyDetailActivity::class.java)
            .apply {
                putExtra(IntentKey.ServiceProvideDetails,serviceProviderCompanyDetail as Serializable)
                putExtra(IntentKey.ServiceCode,serviceCode)
                putExtra(IntentKey.ServiceType,serviceType)
            }
        startActivity(intent)
    }
}