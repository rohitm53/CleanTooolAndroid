package com.cleantool.indiacleantool.common

import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.models.services.Service

object StaticDataProvider {

    fun getServiceDataByType(serviceType: String) : List<Service>{
        val listService = ArrayList<Service>();

        if(serviceType.equals(Constants.House_Hold_Type,true)){

            var service = Service(1,"UT","Utensils", R.drawable.utensils)
            listService.add(service);

            service = Service(1,"MPB","Mopping/Brooming", R.drawable.mopping);
            listService.add(service);

            service = Service(1,"BTH","Bathroom", R.drawable.bathroom);
            listService.add(service);

            service = Service(1,"TLT","Toilet", R.drawable.toilet);
            listService.add(service);

        }else if(serviceType.equals(Constants.Commercial_Type,true)){

            var service = Service(1,"KT","Kitchen", R.drawable.kitchen);
            listService.add(service);

            service = Service(1,"OFC","Office", R.drawable.office);
            listService.add(service);

            service = Service(1,"WRH","Warehouse", R.drawable.warehouse);
            listService.add(service);


        }else if(serviceType.equals(Constants.Laundary_Type)){
            var service = Service(1,"CLTH","Clothes", R.drawable.clothes);
            listService.add(service);

            service = Service(1,"DRCLNG","Dry Cleaning", R.drawable.dry_cleaning);
            listService.add(service);

            service = Service(1,"IRNG","Ironing", R.drawable.ironing);
            listService.add(service);
        }

        return listService;
    }

}