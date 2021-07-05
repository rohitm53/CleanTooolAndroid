package com.cleantool.indiacleantool.customdialog.servicedialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.utils.recylerviewitemdecoration.SpacesItemDecoration
import kotlinx.android.synthetic.main.dialog_services_grid.*

class CustomServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        rv_services.apply {
//            adapter = CustomServiceGridAdapter(listService,serviceSelectorListner)
            layoutManager  = GridLayoutManager(this@CustomServiceActivity,2)
            addItemDecoration(SpacesItemDecoration(10))
        }
    }
}