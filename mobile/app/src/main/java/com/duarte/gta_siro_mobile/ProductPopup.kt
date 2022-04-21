package com.duarte.gta_siro_mobile

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import com.duarte.gta_siro_mobile.adapter.ProductAdapter

class ProductPopup(private val adapter: ProductAdapter) : Dialog(adapter.context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Ne pas afficher la grande barre de titre
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        //Affichage de la page popup
        setContentView(R.layout.popup_produit_details)
    }

}