package com.duarte.gta_siro_mobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.duarte.gta_siro_mobile.R

class ProductAdapter(private val layoutId : Int) : RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    //Boite permettant de ranger les composants
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        //image du produit
        val productPicture = view.findViewById<ImageView>(R.id.imageItem)
    }
    //Permet d'injecter notre layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { }

    //Permet de générer le nombre d'item désiré
    override fun getItemCount(): Int = 8
}