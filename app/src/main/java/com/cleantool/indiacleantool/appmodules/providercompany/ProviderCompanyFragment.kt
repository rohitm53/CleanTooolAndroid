package com.cleantool.indiacleantool.appmodules.providercompany

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R

class ProviderCompanyFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_provider_company,container,false)
        val rv_company_list = view.findViewById<RecyclerView>(R.id.rv_company_list)

        return view

    }

}