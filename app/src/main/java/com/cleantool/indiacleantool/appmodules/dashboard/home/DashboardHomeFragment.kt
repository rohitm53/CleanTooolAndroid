package com.cleantool.indiacleantool.appmodules.dashboard.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.dashboard.ServiceTypeSelectorListner
import com.cleantool.indiacleantool.common.Constants
import com.cleantool.indiacleantool.models.servicetypes.ServiceType
import com.cleantool.indiacleantool.utils.recylerviewitemdecoration.SpacesItemDecoration

class DashboardHomeFragment(
    private var serviceTypeSelectorListner: ServiceTypeSelectorListner
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard_home,container,false)

        val rv_service = view.findViewById<RecyclerView>(R.id.rv_service)

        val gridLayoutManager = GridLayoutManager(context,2)
        rv_service.layoutManager=gridLayoutManager
        rv_service.setHasFixedSize(true)
        rv_service.adapter = HomeServiceTypeGridAdapter(getServiceTypes(),serviceTypeSelectorListner)

        rv_service.addItemDecoration(SpacesItemDecoration(10))

        return view
    }

    private fun getServiceTypes() : List<ServiceType> {

        val listServicesTypes = ArrayList<ServiceType>()

        var serviceType = ServiceType(Constants.House_Hold_Type,R.drawable.house_hold_icon,Constants.House_Hold_Type)
        listServicesTypes.add(serviceType)

        serviceType = ServiceType(Constants.Commercial_Type,R.drawable.commercial_icon,Constants.Commercial_Type)
        listServicesTypes.add(serviceType)

        serviceType = ServiceType(Constants.Laundary_Type,R.drawable.laundary_icon,Constants.Laundary_Type)
        listServicesTypes.add(serviceType)

//        serviceType = ServiceType(Constants.Gardening_Type,R.drawable.garden_icon,Constants.Gardening_Type)
//        listServicesTypes.add(serviceType)

        return listServicesTypes
    }
}