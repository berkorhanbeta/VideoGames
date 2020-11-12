/*
 * Created by Berk Orhan on 13.11.2020
 * APPBeta Mobile | www.APPBeta.net | mobile@appbeta.net
 *
 *TODO           YASAL UYARI
 *
 *                 Bu proje dosyasının herhangi bir amaç ile izinsiz olarak dağıtılması,
 *                 çoğaltılması, satılması ve izinsiz kullanılması yasaktır!
 *
 *                 İzinsiz kullanım, çoğaltımı, dağıtımı, satışı yapıldığı
 *                 tespit edilmesi halinde yasal yollara başvurulacaktır.
 *
 *                  Copyright (c)  2020. Berk Orhan. All rights reserved.
 *
 */



package ise308.orhan.berk.videogames.helper

import android.util.Log

open class ServiceCalculator (var vehicleType : String, var vehicleRepairHour : Int) {

    val car : Int = 150
    val bike : Int = 80
    val bus : Int = 400





    fun calculatePrice(vehicleType : String, vehicleRepairHour : Int) {

        var laborCost : Int

        if(vehicleType.equals("Car")){
            laborCost = car * vehicleRepairHour
            Log.i("@@ Service", "Car Labor cost is : "+laborCost)
        } else if(vehicleType.equals("Bike")) {
            laborCost = bike * vehicleRepairHour
            Log.i("@@Service", "Bike Labor cost is : "+laborCost)
        } else if (vehicleType.equals("Bus")){
            laborCost = bus * vehicleRepairHour
            Log.i("@@ Service", "Bus Labor cost is : "+laborCost)
        }

    }



    open fun isNeedTow() {
        Log.i("@@ Service", "Towing Price")
    }
}