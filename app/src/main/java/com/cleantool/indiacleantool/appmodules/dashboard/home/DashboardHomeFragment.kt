package com.cleantool.indiacleantool.appmodules.dashboard.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.models.services.Services
import com.cleantool.indiacleantool.utils.recylerviewitemdecoration.SpacesItemDecoration

class DashboardHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard_home,container,false)

        val rv_service = view.findViewById<RecyclerView>(R.id.rv_service)

        val gridLayoutManager = GridLayoutManager(context,3)
        rv_service.layoutManager=gridLayoutManager
        rv_service.setHasFixedSize(true)
        rv_service.adapter = HomeServiceGridAdapter(this.requireActivity(),loadData())

        rv_service.addItemDecoration(SpacesItemDecoration(10))

        return view
    }

    private fun loadData() : List<Services> {

        val listServices = ArrayList<Services>()

        var services = Services("Basic Cleaning",R.drawable.home_icon)
        listServices.add(services)

        services = Services("Home Cleaning",R.drawable.home_icon)
        listServices.add(services)

        services = Services("Office Cleaning",R.drawable.home_icon)
        listServices.add(services)

        services = Services("Move in cleaning",R.drawable.home_icon)
        listServices.add(services)

        services = Services("Move out cleaning",R.drawable.home_icon)
        listServices.add(services)

        services = Services("After Party Cleaning",R.drawable.home_icon)
        listServices.add(services)

        services = Services("Clothes Cleaning",R.drawable.home_icon)
        listServices.add(services)

        services = Services("Clothes Cleaning",R.drawable.home_icon)
        listServices.add(services)


        services = Services("Car Cleaning",R.drawable.home_icon)
        listServices.add(services)

        return listServices
    }
}