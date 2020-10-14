package com.cleantool.indiacleantool.appmodules.providercompany

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.ServiceProviderCompanyDetail
import kotlinx.android.synthetic.main.fragment_service_provider_company.*

class ServiceProviderCompanyFragment(
    private  var serviceProviderCompanyDetail: ServiceProviderCompanyDetail,
    private var companyDetailsListner: CompanyDetailsListner
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_service_provider_company,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val company = serviceProviderCompanyDetail.company
        val listTimeSlot = serviceProviderCompanyDetail.timeSlots

        tv_company_name.text = "${company.companyName}  (${company.companyCode})"
        tv_company_address.text = company.address
        if(serviceProviderCompanyDetail.availableEmployeeCount>9){
            tv_avail_peron.text = "${serviceProviderCompanyDetail.availableEmployeeCount}"
        }else{
            tv_avail_peron.text = "0${serviceProviderCompanyDetail.availableEmployeeCount}"
        }


        rv_time_slot.apply {
            adapter = CompanyTimeSlotsAdapter(listTimeSlot,companyDetailsListner)
            layoutManager = LinearLayoutManager(activity)
        }

        ed_req_peron.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(str: Editable?) {
                companyDetailsListner.onReadRequiredPerson(str.toString().toInt())
            }
        })
    }

}