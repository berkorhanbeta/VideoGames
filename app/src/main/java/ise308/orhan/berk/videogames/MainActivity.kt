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


package ise308.orhan.berk.videogames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ise308.orhan.berk.videogames.helper.Bike
import ise308.orhan.berk.videogames.helper.Bus
import ise308.orhan.berk.videogames.helper.Car
import ise308.orhan.berk.videogames.helper.ServiceCalculator

class MainActivity : AppCompatActivity(){

    // Creating Objects and Variables
    lateinit var floatingActionButton : FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatingActionButton = findViewById(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener(){
            startActivity(Intent(this,ProfileActivity::class.java))
        }


        calculatePrice()


    }


    fun calculatePrice(){

        val bike = Bike("Bike",3)
        val l_Bike = ServiceCalculator("Bike",3)
        bike.isNeedTow()
        l_Bike.calculatePrice("Bike",3)


        val car = Car("Car",10)
        val l_Car = ServiceCalculator("Car",10)
        car.isNeedTow()
        l_Car.calculatePrice("Car",10)


        val bus = Bus("Bus",5)
        val l_Bus = ServiceCalculator("Bus",5)
        bus.isNeedTow()
        l_Bus.calculatePrice("Bus",5)
    }

}