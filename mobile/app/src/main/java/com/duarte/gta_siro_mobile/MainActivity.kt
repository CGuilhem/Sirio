package com.duarte.gta_siro_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.duarte.gta_siro_mobile.databinding.ActivityMainBinding
import com.duarte.gta_siro_mobile.fragments.*
import com.duarte.gta_siro_mobile.model.ProductModel
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
        var productList: List<ProductModel> = emptyList()
        model.data.observe(this) {
            if (it == null) {
                //Ne rien faire
            } else {
                productList = it
                //Chargement par défaut
                loadFragment(HomeFragment(this, productList), R.string.menu_home)
            }
        }

        //importer la bottom navigation view
        val navigationView = findViewById<BottomNavigationView>(R.id.navigationView)
        navigationView.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.menu_home_page -> {
                    loadFragment(HomeFragment(this, productList), R.string.menu_home)
                    true
                }
                R.id.menu_search_page -> {
                    loadFragment(SearchFragment(this), R.string.menu_search)
                    true
                }
                R.id.menu_favorites_page -> {
                    loadFragment(FavoritesFragment(this, productList), R.string.menu_favorites)
                    true
                }
                R.id.menu_cart_page -> {
                    loadFragment(CartFragment(this), R.string.menu_cart)
                    true
                }
                R.id.menu_account_page -> {
                    loadFragment(AccountFragment(this), R.string.menu_account)
                    true
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