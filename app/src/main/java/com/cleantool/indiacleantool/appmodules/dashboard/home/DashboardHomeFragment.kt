package com.cleantool.indiacleantool.appmodules.dashboard.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.dashboard.CleanTypeSelectorListner
import com.cleantool.indiacleantool.common.Constants
import com.cleantool.indiacleantool.models.services.Services
import com.cleantool.indiacleantool.utils.recylerviewitemdecoration.SpacesItemDecoration

class DashboardHomeFragment() : Fragment() {

    private lateinit var cleanTypeSelectorListner: CleanTypeSelectorListner

    constructor(cleanTypeSelectorListner: CleanTypeSelectorListner) : this() {
        this.cleanTypeSelectorListner=cleanTypeSelectorListner
    }

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
        rv_service.adapter = HomeServiceGridAdapter(this.requireActivity(),loadData(),cleanTypeSelectorListner)

        rv_service.addItemDecoration(SpacesItemDecoration(1))

        return view
    }

    private fun loadData() : List<Services> {

        val listServices = ArrayList<Services>()

        var services = Services(Constants.House_Hold_Services,R.drawable.house_hold_icon,Constants.House_Hold_Services)
        listServices.add(services)

        services = Services(Constants.Commercial_Services,R.drawable.commercial_icon,Constants.Commercial_Services)
        listServices.add(services)

        services = Services(Constants.Laundary_Service,R.drawable.laundary_icon,Constants.Laundary_Service)
        listServices.add(services)

        services = Services(Constants.Gardening_Service,R.drawable.garden_icon,Constants.Gardening_Service)
        listServices.add(services)

        return listServices
    }
}