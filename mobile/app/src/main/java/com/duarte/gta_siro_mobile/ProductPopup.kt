package com.duarte.gta_siro_mobile

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.duarte.gta_siro_mobile.adapter.ProductAdapter
import com.duarte.gta_siro_mobile.model.ProductModel

class ProductPopup(private val adapter: ProductAdapter, private val currentProduct : ProductModel) : Dialog(adapter.context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Ne pas afficher la grande barre de titre
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        //Affichage de la page popup
        setContentView(R.layout.popup_produit_details)
        setupComponents()
        setupCloseButton()
        setupFavoriteButton()
    }

    private fun updateFavoriteButton(button: ImageView){
        if(currentProduct.liked){
            button.setImageResource(R.drawable.ic__favorite_red_24)
        }else{
            button.setImageResource(R.drawable.ic_not_favorite)
        }
    }

    private fun setupFavoriteButton() {
        //Récupération du bouton like
        val favoriteButton = findViewById<ImageView>(R.id.favorite_button)

        updateFavoriteButton(favoriteButton)

        //Interaction avec le bouton like
        favoriteButton.setOnClickListener {
            currentProduct.liked = !currentProduct.liked
            updateFavoriteButton(favoriteButton)
        }
    }

    private fun setupCloseButton() {
        findViewById<ImageView>(R.id.close_button).setOnClickListener {
            //Fermer la popup
            dismiss()
        }
    }

    private fun setupComponents() {
        //Actualiser l'image du produit
        val productImage = findViewById<ImageView>(R.id.imageItem_Product)
        Glide.with(adapter.context).load(Uri.parse(currentProduct.imageUrl)).into(productImage)

        //Actualiser le nom du produit dans la popup
        findViewById<TextView>(R.id.popup_product_name).text = currentProduct.name

        //Actualiser le prix
        findViewById<TextView>(R.id.product_price).text = currentProduct.price
    }

}