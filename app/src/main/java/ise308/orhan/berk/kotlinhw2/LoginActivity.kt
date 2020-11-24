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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ise308.orhan.berk.kotlinhw2.helper.AccountHelper

class LoginActivity : AppCompatActivity() {


        // Variables, Objects
     lateinit var login : Button
     lateinit var eposta : EditText
     lateinit var password : EditText
     lateinit var sign_up : TextView
     var s_eposta  = "eposta"
     var s_password = "sifre"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Actionbar definition
        var actionbar = supportActionBar
        actionbar?.hide() // Hiding ActionBar

        // Creating, getting SharedPreferences
        val prefences = getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
        // Getting default value of SharedPreferences
        s_eposta = prefences.getString("s_eposta", "a").toString() // Getting default value of SharedPreferences
        s_password = prefences.getString("s_password", "a").toString()

        Toast.makeText(this,getString(R.string.current_Mail)+s_eposta + "\n"+getString(R.string.current_Password) + s_password, Toast.LENGTH_LONG).show()

        // XML Object Definitions
        login = findViewById(R.id.login_button)
        eposta = findViewById(R.id.login_eposta)
        password = findViewById(R.id.login_password)
        sign_up = findViewById(R.id.login_register_button)
        login = findViewById(R.id.login_button)

        // Whats happing when we click the sign-up button
        sign_up.setOnClickListener(){
            startActivity(Intent(this, RegisterActivity::class.java))

        }

        // Whats happing when we click the log-in button
        login.setOnClickListener(){

            // Sending user input account information.
            val login = AccountHelper(eposta.text.toString(), password.text.toString(), s_eposta, s_password)

            // Calling attempLogin function in the AccountHelper class and checking account information
            if(login.attempLogin() == true){
                    // If login is successful, then start the new activity.
                startActivity(Intent(this, MainActivity::class.java))

            } else {
                Toast.makeText(this, getString(R.string.password_not_match), Toast.LENGTH_LONG).show()
            }

        }
    }

}


