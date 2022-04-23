package com.duarte.gta_siro_mobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duarte.gta_siro_mobile.MainActivity
import com.duarte.gta_siro_mobile.ProductViewModel
import com.duarte.gta_siro_mobile.R
import com.duarte.gta_siro_mobile.adapter.ProductAdapter
import com.duarte.gta_siro_mobile.adapter.ProductItemDecoration
import com.duarte.gta_siro_mobile.model.ProductModel

class FavoritesFragment(private val context: MainActivity) : Fragment()  {
    val model by lazy { ViewModelProvider(this).get(ProductViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Création d'une liste qui stock les produits
        var productList = arrayListOf<ProductModel>()

        val view = inflater?.inflate(R.layout.fragment_favorites, container, false)

        //Recupérer le recyclerView de favoris
        val favortitesRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_fav_VerticalList)
        //ajouter le layout favorite_horizontal_info_product
        //var product:List<ProductModel> = List()
//        if(model.data.value != null)
//        {
//            productList = model.data.value!!
//        }
        favortitesRecyclerView?.adapter = ProductAdapter(context, productList, R.layout.item_vertical_product)
        favortitesRecyclerView.layoutManager = LinearLayoutManager(context)
        //Permet d'espacer les produits
        favortitesRecyclerView.addItemDecoration(ProductItemDecoration())

        return view
    }

}