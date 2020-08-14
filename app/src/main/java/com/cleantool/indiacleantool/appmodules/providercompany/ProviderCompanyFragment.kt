package com.cleantool.indiacleantool.appmodules.providercompany

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.models.providingcompany.ProvidingCompanyTimeSlotsDetails

class ProviderCompanyFragment() : Fragment() {

    private lateinit var providingCompanyTimeSlots: ProvidingCompanyTimeSlotsDetails

    constructor(providingCompanyTimeSlots: ProvidingCompanyTimeSlotsDetails) : this(){
        this.providingCompanyTimeSlots=providingCompanyTimeSlots
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_provider_company,container,false)
        val rv_company_list = view.findViewById<RecyclerView>(R.id.rv_company_list)

        val linearLayoutManager  = LinearLayoutManager(context)
        rv_company_list.layoutManager=linearLayoutManager
        rv_company_list.setHasFixedSize(true)
        rv_company_list.adapter = ProviderCompanyListAdapter(this.requireContext(),providingCompanyTimeSlots.timeSlots)
        return view

    }



}