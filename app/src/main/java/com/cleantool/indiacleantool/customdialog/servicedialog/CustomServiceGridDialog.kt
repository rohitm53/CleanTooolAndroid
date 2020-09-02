package com.cleantool.indiacleantool.customdialog.servicedialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.customdialog.CustomServiceGridAdapter
import com.cleantool.indiacleantool.models.services.Service
import com.cleantool.indiacleantool.utils.recylerviewitemdecoration.SpacesItemDecoration

class CustomServiceGridDialog : Dialog {

    private var  mContext : Context
    private var listService:List<Service>;
    private lateinit var rv_services : RecyclerView;

    constructor(mContext : Context,listService:List<Service>) : super(mContext){
        this.mContext=mContext
        this.listService=listService;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_services_grid);
        rv_services = findViewById(R.id.rv_services);

        val adapter = CustomServiceGridAdapter(mContext,ArrayList<Service>());
        val gridLayoutManager  = GridLayoutManager(mContext,2)
        rv_services.setHasFixedSize(true)
        rv_services.adapter = adapter
        rv_services.addItemDecoration(SpacesItemDecoration(10))
        rv_services.layoutManager=gridLayoutManager
        adapter.refresh(listService);
    }




}