package com.cleantool.indiacleantool.appmodules.dashboard.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.cleantool.indiacleantool.R

class DashboardHomeFragment : Fragment {

    var position : Int = 0

    constructor( position : Int){
        this.position=position
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard_home,container,false)
        val textview = view.findViewById<TextView>(R.id.textview)
        val content = view.findViewById<ScrollView>(R.id.content)
        textview.text= (position+1).toString()
        if(position==0){
            content.setBackgroundColor(ResourcesCompat.getColor(getResources(),R.color.colorPrimary,null))
        }else if(position==1){
            content.setBackgroundColor(ResourcesCompat.getColor(getResources(),R.color.colorAccent,null))
        }else if(position==2){
            content.setBackgroundColor(ResourcesCompat.getColor(getResources(),R.color.app_color,null))
        }else{
            content.setBackgroundColor(ResourcesCompat.getColor(getResources(),R.color.orange,null))
        }

        return view
    }
}