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
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import ise308.orhan.berk.kotlinhw2.helper.AccountHelper

class ProfileActivity : AppCompatActivity() {

    // Variables, Objects
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

        // Actionbar definition
        var actionbar = supportActionBar
        actionbar?.hide() // Hiding ActionBar

        // XML Object Definitions
        update = findViewById(R.id.profile_button)
        current_password = findViewById(R.id.profile_password)
        new_password = findViewById(R.id.profile_new_password)
        profile_fullname = findViewById(R.id.profile_fullname)
        profile_eposta = findViewById(R.id.profile_eposta)
        back_button = findViewById(R.id.back_button)

        // Whats happing when we click the back button
        back_button.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Creating, getting SharedPreferences
        val prefences = getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
        val editor = prefences.edit()

        // Generated the edittext inputs to String
        profile_fullname.text = prefences.getString("s_fullname", "a").toString()
        profile_eposta.text = prefences.getString("s_eposta", "b").toString()
        c_password = prefences.getString("s_password", "a").toString()

        // Whats happing when we click the update button
        update.setOnClickListener(){

            // Sending user input account information.
            val update_info = AccountHelper(new_password.text.toString(), c_password)

            // Calling changePassword function in the AccountHelper class and checking account information
            if(update_info.changePassword() == true){
                // If account information is correct, then we change the password.
                editor.putString("s_password", new_password.text.toString())
                editor.apply() // Adding the new password to SharedPreferences
                Toast.makeText(this,"Your password successfuly changed!", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, ProfileActivity::class.java))

            } else {
                Toast.makeText(this,"Passwords Doesn't Match!", Toast.LENGTH_LONG).show()
            }
        }


    }

}