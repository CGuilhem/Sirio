package com.duarte.gta_siro_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.duarte.gta_siro_mobile.databinding.ActivityMainBinding
import com.duarte.gta_siro_mobile.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(){
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val model by lazy { ViewModelProvider(this).get(ProductViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Chargemet des données
        model.loadData()
        // Test de l'affichage
        model.data.observe(this) {
            if (it == null) {

            } else {
                for (product in it) {
                    print(product.name)
                }
            }
        }

//        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment(this), R.string.menu_home)

        //importer la bottom navigatio view
        val navigationView = findViewById<BottomNavigationView>(R.id.navigationView)
        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home_page -> {
                    loadFragment(HomeFragment(this), R.string.menu_home)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_search_page -> {
                    loadFragment(SearchFragment(this), R.string.menu_search)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_home_page -> {
                    loadFragment(FavoritesFragment(this), R.string.menu_favorites)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_home_page -> {
                    loadFragment(CartFragment(this), R.string.menu_cart)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_home_page -> {
                    loadFragment(AccountFragment(this), R.string.menu_account)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment, string: Int) {
        //Actualiser le titre de la page
        findViewById<TextView>(R.id.app_title).text = resources.getString(string)
        //Injection du frament
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)                                                                //Remplace le contenu du container dans le layout
        transaction.addToBackStack(null)                           //Ne pas avoir de retour sur ce composant
        transaction.commit()
    }


}