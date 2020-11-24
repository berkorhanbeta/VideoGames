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

class Bike(vehicleType : String, vehicleRepairHour : Int): ServiceCalculator(vehicleType, vehicleRepairHour) {


    init {
        Log.i(Companion.TAG,"Vehicle Type is "+vehicleType+" and vehicle damage repair hour is : "+vehicleRepairHour)
    }

    // Towing Function
    override fun isNeedTow() {
            Log.i(Companion.TAG,"Needs to be towing, Tow Price is $50")
    }

    // Objects, Variables
    var brand: String = ""
    var damage : String = ""
    var color : String = ""

        // Get Method
        get() {
            return field.toString()
        }

        // Set Method
        set(value) {
            field = value
        }

    companion object {
        const val TAG = "@@ Bike"
    }
}