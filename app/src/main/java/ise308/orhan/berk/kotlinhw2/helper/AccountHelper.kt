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

class AccountHelper constructor() {

    // Variables, Objects
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


        // Login Info Check Function
    fun attempLogin(): Boolean {

        return when {
            // If e-posta and password not corret
            !system_mail.equals(user_eposta) || !system_password.equals(user_password) -> {
                // Then do this
                Log.i("LoginHelper : ", "Password or Mail Address Wrong!")
                Log.i("LoginHelper  UserID : ", user_eposta)
                Log.i("LoginHelper UserPass: ", user_password)
                Log.i("LoginHelper SMail : ", system_mail)
                Log.i("LoginHelper SPass : ", system_password)
                // Boolen return false
                false
            }
            // If correct, then boolen return true
            else -> true
        }
    }


    // Account Password Changer
    fun changePassword(): Boolean {


        return when {
            // If current password not correct
            !user_password.equals(system_password) -> {
                    // Then do this
                Log.i("LoginHelper : ", "Old Password Is Wrong!")
                Log.i("LoginHelper  SPass : ", user_password)
                Log.i("LoginHelper UPass: ", system_password)
                // Boolen return false
                false
            }
            // If password is correct, then boolen return true
            else -> true
        }
    }

}