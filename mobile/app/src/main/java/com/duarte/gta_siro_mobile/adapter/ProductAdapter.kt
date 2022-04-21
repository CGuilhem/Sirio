package com.duarte.gta_siro_mobile.adapter

import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.duarte.gta_siro_mobile.MainActivity
import com.duarte.gta_siro_mobile.R
import com.duarte.gta_siro_mobile.model.ProductModel

class ProductAdapter(private val context : MainActivity, private val productList : List<ProductModel>, private val layoutId : Int) : RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    //Boite permettant de ranger les composants
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        //Image du produit
        val productPicture = view.findViewById<ImageView>(R.id.imageItem)
        //Nom du produit en lien avec le layout
        val productName:TextView? = view.findViewById<TextView>(R.id.textViewProductName)
        val productPrice:TextView? = view.findViewById<TextView>(R.id.textViewProductPrice)
        val favoriteIcon = view.findViewById<ImageView>(R.id.imageViewFavorite)
    }
    //Permet d'injecter notre layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    //Permet de recupérer les informations des produits
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProduct = productList[position]

        //Utilisation de la librairie Glide pour récupérer l'image à partir du lien
        Glide.with(context).load(Uri.parse(currentProduct.imageUrl)).into(holder.productPicture) //Uri.parse() permet de convertir l'url de l'image en une action android

        //Mettre à jour le nom du produit
        holder.productName?.text = currentProduct.name

        //Mise à jour du prix
        holder.productPrice?.text = currentProduct.price

        //vérifier si le produit est liké
        if(currentProduct.liked){
            holder.favoriteIcon.setImageResource(R.drawable.ic__favorite_red_24)
        }else{
            holder.favoriteIcon.setImageResource(R.drawable.ic_not_favorite)
        }
        //Interaction sur le bouton like
        holder.favoriteIcon.setOnClickListener{
            //Inverse ou non si le bouton est like ou pas
            currentProduct.liked = !currentProduct.liked
            //Met à jour l'objet produit

        }
    }

    //Permet de générer le nombre d'item désiré
    override fun getItemCount(): Int = productList.size
}