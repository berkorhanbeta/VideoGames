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
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class RegisterActivity : AppCompatActivity() {

    // Variables, Objects
    lateinit var register : Button
    lateinit var eposta : EditText
    lateinit var full_name : EditText
    lateinit var password : EditText
    lateinit var re_password : EditText
    lateinit var sign_in : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        // Actionbar definition
        var actionbar = supportActionBar
        actionbar?.hide() // Hiding ActionBar

        // Creating, getting, editing SharedPreferences
        val prefences = getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
        val editor = prefences.edit()

        // XML Object Definitions
        register = findViewById(R.id.register_button)
        full_name = findViewById(R.id.reg_fullname)
        eposta = findViewById(R.id.reg_eposta)
        password = findViewById(R.id.reg_cre_password)
        re_password = findViewById(R.id.reg_conf_password)

        sign_in = findViewById(R.id.register_login_button)
        register = findViewById(R.id.register_button)

        // Whats happing when we click the sign-in button
        sign_in.setOnClickListener(){
            onBackPressed() // Go back
        }

        // Whats happing when we click the register button
        register.setOnClickListener(){

            // Sending user input account information to CreateAccount class
            val new_user = CreateAccount(this, full_name.text.toString(), eposta.text.toString(), password.text.toString(), re_password.text.toString())

            // Checking if all the information needed is correct
            if (new_user.acc_check(password.text.toString(), re_password.text.toString()) == true &&
                    new_user.acc_check(eposta.text.toString()) == true &&
                    new_user.acc_check(full_name.text.toString()) == true) {

                // If all the informations is correct then, add the info to SharedPreferences
                editor.putString("s_fullname", new_user.name)
                editor.putString("s_eposta", new_user.eposta)
                editor.putString("s_password", new_user.password)
                editor.apply()
                Toast.makeText(this,"Full Name : ${new_user.name}\nE-Posta : ${new_user.eposta}\nPassword : ${new_user.password}", Toast.LENGTH_LONG).show()
                // Starting the Login Activity
                startActivity(Intent(this, LoginActivity::class.java))
            }




        }

    }



    // Function Overload Ex :
    class CreateAccount(val context: Context, var name : String, var eposta : String, var password : String, var conf_password : String) {

        // Password Check Function
        fun acc_check(password : String, conf_password: String): Boolean {

            return when {
                !password.equals(conf_password) -> {

                    Toast.makeText(context, "Passwords does not match!", Toast.LENGTH_LONG).show()
                    false
                }

                else -> true
            }
       }

        // E-posta check function
        fun acc_check(eposta: String): Boolean {

            return when {
                eposta.isEmpty() || eposta.length<2 -> {

                    Toast.makeText(context, "E-Mail Address or Full Name is cannot be empty!", Toast.LENGTH_LONG).show()
                    false
                }

                else -> true
            }
        }

    }



}



