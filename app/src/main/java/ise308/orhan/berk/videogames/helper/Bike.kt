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

class Bike(vehicleType : String, vehicleRepairHour : Int): ServiceCalculator(vehicleType, vehicleRepairHour) {


    init {
        Log.i("@@ Bike","Vehicle Type is "+vehicleType+" and vehicle damage repair hour is : "+vehicleRepairHour)
    }

    override fun isNeedTow() {
            Log.i("@@ Bike","Needs to be towing, Tow Price is $50")
    }
}