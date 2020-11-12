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

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import ise308.orhan.berk.videogames.helper.AccountHelper

class ProfileActivity : AppCompatActivity() {

    lateinit var update : Button
    lateinit var current_password : EditText
    lateinit var new_password : EditText
    lateinit var profile_fullname : TextView
    lateinit var profile_eposta : TextView
    lateinit var back_button : ImageView

    var c_password = "sifre"




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var actionbar = supportActionBar
        actionbar?.hide()

        update = findViewById(R.id.profile_button)
        current_password = findViewById(R.id.profile_password)
        new_password = findViewById(R.id.profile_new_password)
        profile_fullname = findViewById(R.id.profile_fullname)
        profile_eposta = findViewById(R.id.profile_eposta)
        back_button = findViewById(R.id.back_button)

        back_button.setOnClickListener(){
            startActivity(Intent(this,MainActivity ::class.java))
        }

        val prefences = getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
        val editor = prefences.edit()

        profile_fullname.text = prefences.getString("s_fullname", "a").toString()
        profile_eposta.text = prefences.getString("s_eposta", "b").toString()
        c_password = prefences.getString("s_password", "a").toString()

        update.setOnClickListener(){
            val update_info = AccountHelper(new_password.text.toString(), c_password)
            if(update_info.changePassword() == true){

                editor.putString("s_password", new_password.text.toString())
                editor.apply()
                Toast.makeText(this,"Your password successfuly changed!", Toast.LENGTH_LONG).show()
                startActivity(Intent(this,ProfileActivity::class.java))

            } else {
                Toast.makeText(this,"Passwords Doesn't Match!", Toast.LENGTH_LONG).show()
            }
        }


    }

}