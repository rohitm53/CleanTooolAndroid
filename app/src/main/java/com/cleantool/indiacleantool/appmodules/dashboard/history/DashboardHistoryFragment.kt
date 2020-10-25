package com.cleantool.indiacleantool.appmodules.dashboard.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.dashboard.DashboardActivity
import com.cleantool.indiacleantool.appmodules.dashboard.history.DashboardHistoryViewModal.Companion.ERROR
import com.cleantool.indiacleantool.appmodules.dashboard.history.DashboardHistoryViewModal.Companion.SERVICE_REQUEST_FETCHED
import com.cleantool.indiacleantool.appmodules.dashboard.history.DashboardHistoryViewModal.Companion.SHOW_LOADER
import com.cleantool.indiacleantool.models.networkmodels.servicerequest.ServiceRequest
import kotlinx.android.synthetic.main.fragment_dashboard_history.*

class DashboardHistoryFragment : Fragment() {

    val viewModal by viewModels<DashboardHistoryViewModal>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_dashboard_history,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModal.getAllPendingServiceRequest()

        viewModal.statusLiveData.observe(viewLifecycleOwner,{ it->

            when(it.status) {

                SHOW_LOADER -> {
                    (activity as DashboardActivity).showLoader(it.data.toString())
                }

                SERVICE_REQUEST_FETCHED -> {
                    (activity as DashboardActivity).hideLoader()
                    val listPendingService = it.data as List<ServiceRequest>
                    updatePendingServiceList(listPendingService)
                }

                ERROR -> {
                    (activity as DashboardActivity).hideLoader()
                    (activity as DashboardActivity).showAlert(it.data.toString(),{dialog,which->},{dialog,which->})
                }

            }
        })

        swipe_refresh.setOnRefreshListener {
            viewModal.getAllPendingServiceRequest()
            swipe_refresh.isRefreshing=false
        }
    }

    private fun updatePendingServiceList(listPendingService : List<ServiceRequest>){
        rc_pending_service.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PendingServiceRequestAdapter(requireContext(),listPendingService)
        }
    }
}