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

import android.content.Context
import android.util.Log
import android.widget.Toast
import ise308.orhan.berk.videogames.LoginActivity

class AccountHelper constructor() {

    var system_mail: String = ""
    var system_password: String = ""
    var user_eposta: String = ""
    var user_password: String = ""


    constructor(u_eposta: String, u_password: String, s_eposta: String, s_password: String) : this() {

        this.user_eposta = u_eposta
        this.user_password = u_password
        this.system_mail = s_eposta
        this.system_password = s_password

    }


    constructor(c_password: String, n_password: String) : this() {

        this.system_password = c_password
        this.user_password = n_password

    }



    fun attempLogin(): Boolean {

        return when {
            !system_mail.equals(user_eposta) || !system_password.equals(user_password) -> {

                Log.i("LoginHelper : ", "Password or Mail Address Wrong!")
                Log.i("LoginHelper  UserID : ", user_eposta)
                Log.i("LoginHelper UserPass: ", user_password)
                Log.i("LoginHelper SMail : ", system_mail)
                Log.i("LoginHelper SPass : ", system_password)
                false
            }

            else -> true
        }
    }


    fun changePassword(): Boolean {


        return when {
            !user_password.equals(system_password) -> {

                Log.i("LoginHelper : ", "Old Password Is Wrong!")
                Log.i("LoginHelper  SPass : ", user_password)
                Log.i("LoginHelper UPass: ", system_password)
                false
            }

            else -> true
        }
    }

}