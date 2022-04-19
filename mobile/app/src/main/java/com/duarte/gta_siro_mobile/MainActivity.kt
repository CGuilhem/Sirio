package com.duarte.gta_siro_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.duarte.gta_siro_mobile.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Injection du frament
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, HomeFragment())     //Remplace le contenu du container dans le layout
        transaction.addToBackStack(null)                           //Ne pas avoir de retour sur ce composant
        transaction.commit()                                             //Renvoyer ce composant

    }
}