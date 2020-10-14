package com.cleantool.indiacleantool.customdialog.servicedialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import androidx.recyclerview.widget.GridLayoutManager
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.dashboard.settings.ServiceSelectorListner
import com.cleantool.indiacleantool.customdialog.CustomServiceGridAdapter
import com.cleantool.indiacleantool.models.services.Service
import com.cleantool.indiacleantool.utils.recylerviewitemdecoration.SpacesItemDecoration
import kotlinx.android.synthetic.main.dialog_services_grid.*

class CustomServiceGridDialog(
    private var mContext: Context,
    private var listService: List<Service>,
    private var serviceSelectorListner: ServiceSelectorListner
) : Dialog(mContext) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_services_grid)

        rv_services.apply {
            adapter = CustomServiceGridAdapter(listService,serviceSelectorListner)
            layoutManager  = GridLayoutManager(mContext,2)
            addItemDecoration(SpacesItemDecoration(10))
        }
    }

}