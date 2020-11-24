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



package ise308.orhan.berk.kotlinhw2.helper

import android.util.Log

open class ServiceCalculator (var vehicleType : String, var vehicleRepairHour : Int) {

    // Creating objects and Variables
    val TAG = "@@ ServiceCalculator"
    val car : Int = 150
    val bike : Int = 80
    val bus : Int = 400




    // CalculatePrice function
    fun calculatePrice(vehicleType : String, vehicleRepairHour : Int) {

        // Object, Variable
        var laborCost : Int

        // Finding Vehicle Type
        if(vehicleType.equals("Car")){
            laborCost = car * vehicleRepairHour // multiplication, car labor cost and Repair Hour
            Log.i(TAG, "Car Labor cost is : "+laborCost)
        } else if(vehicleType.equals("Bike")) {
            laborCost = bike * vehicleRepairHour // multiplication, car labor cost and Repair Hour
            Log.i(TAG, "Bike Labor cost is : "+laborCost)
        } else if (vehicleType.equals("Bus")){
            laborCost = bus * vehicleRepairHour // multiplication, car labor cost and Repair Hour
            Log.i(TAG, "Bus Labor cost is : "+laborCost)
        }

    }



    // Towing Fucntion
    open fun isNeedTow() {
        Log.i(TAG, "Towing Price")
    }
}
