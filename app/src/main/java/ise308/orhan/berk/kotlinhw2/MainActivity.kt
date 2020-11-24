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


package ise308.orhan.berk.kotlinhw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ise308.orhan.berk.kotlinhw2.helper.Bike
import ise308.orhan.berk.kotlinhw2.helper.Bus
import ise308.orhan.berk.kotlinhw2.helper.Car
import ise308.orhan.berk.kotlinhw2.helper.ServiceCalculator

class MainActivity : AppCompatActivity(){

     val TAG = "@@ MainActivity"
    // Creating Objects and Variables
    lateinit var floatingActionButton : FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // What's happen when we click the float action button?
        floatingActionButton = findViewById(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener(){
            // Opening the profile activity.
            startActivity(Intent(this, ProfileActivity::class.java))
        }


        // Calling function.
        calculatePrice()


    }


    fun calculatePrice(){

        // Calling Bike class.
        val bike = Bike(getString(R.string.bike), getString(R.string.bikeRepairHour).toInt())

        // Seting bike details in the Bike Class.
        bike.brand = getString(R.string.bikeBrand)
        bike.color = getString(R.string.bikeColor)
        bike.damage = getString(R.string.bikeDamage)

        // Getting the bike details in Bike Class.
        Log.i(TAG,getString(R.string.bikeDamageIs)+"${bike.damage}")
        Log.i(TAG,getString(R.string.bikeBrandIs)+"${bike.brand}")
        Log.i(TAG,getString(R.string.bikeColorIs)+"${bike.color}")

        // Calling ServiceCalculator class
        val l_Bike = ServiceCalculator(getString(R.string.bike), getString(R.string.bikeRepairHour).toInt())
        // Override the isNeedTow function.
        bike.isNeedTow()
        // Calling the calculatePrice function in ServiceCalculator class.
        l_Bike.calculatePrice(getString(R.string.bike),getString(R.string.bikeRepairHour).toInt())


        Log.i(TAG, "@@@@@@@@@@@@@@@@@@@@@ New Info @@@@@@@@@@@@@@@@@@@@@")


        // Calling Car class.
        val car = Car(getString(R.string.car), getString(R.string.carRepairHour).toInt())

        // Seting car details in the Car Class.
        car.brand = getString(R.string.carBrand)
        car.convertible = getString(R.string.carConvertible)
        car.door = getString(R.string.carDoor)
        car.damage = getString(R.string.carDamage)

        // Getting the car details in Car Class.
        Log.i("@@ MainActivity",getString(R.string.carDamageIs)+"${car.damage}")
        Log.i("@@ MainActivity",getString(R.string.carBrandIs)+"${car.brand}")
        Log.i("@@ MainActivity",getString(R.string.carIsConvertible)+"${car.convertible}")
        Log.i("@@ MainActivity",getString(R.string.HowManyDoor)+"${car.door}")
        // Calling ServiceCalculator class
        val l_Car = ServiceCalculator(getString(R.string.car), getString(R.string.carRepairHour).toInt())
        // Override the isNeedTow function.
        car.isNeedTow()
        // Calling the calculatePrice function in ServiceCalculator class.
        l_Car.calculatePrice(getString(R.string.car),getString(R.string.carRepairHour).toInt())


        Log.i(TAG, "@@@@@@@@@@@@@@@@@@@@@ New Info @@@@@@@@@@@@@@@@@@@@@")


        // Calling Bus class.
        val bus = Bus(getString(R.string.bus), getString(R.string.busRepairHour).toInt())

        // Seting bus details in the Bus Class.
        bus.brand = getString(R.string.busBrand)
        bus.doubleDecker = getString(R.string.doubleDecker)
        bus.door = getString(R.string.busDoor)
        bus.damage = getString(R.string.busDamage)

        // Getting the bus details in Bus Class.
        Log.i(TAG,getString(R.string.busDamageIs)+"${bus.damage}")
        Log.i(TAG,getString(R.string.busBrandIs)+"${bus.brand}")
        Log.i(TAG,getString(R.string.busIsDoubleDecker)+"${bus.doubleDecker}")
        Log.i(TAG,getString(R.string.HowManyDoor)+"${bus.door}")
        // Calling ServiceCalculator class
        val l_Bus = ServiceCalculator(getString(R.string.bus), getString(R.string.busRepairHour).toInt())
        // Override the isNeedTow function.
        bus.isNeedTow()
        // Calling the calculatePrice function in ServiceCalculator class.
        l_Bus.calculatePrice(getString(R.string.bus),getString(R.string.busRepairHour).toInt())
    }

}