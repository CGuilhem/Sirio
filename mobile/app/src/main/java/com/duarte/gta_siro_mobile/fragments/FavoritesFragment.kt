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

class FavoritesFragment(private val context: MainActivity, productsList : List<ProductModel>) : Fragment()  {
    val productList = productsList

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater?.inflate(R.layout.fragment_favorites, container, false)

        //Recupérer le recyclerView de favoris
        val favortitesRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_fav_VerticalList)

        favortitesRecyclerView?.adapter = ProductAdapter(context, productList.filter { it.liked }, R.layout.item_horizontal_info_product)
        favortitesRecyclerView.layoutManager = LinearLayoutManager(context)

        //Permet d'espacer les produits
        favortitesRecyclerView.addItemDecoration(ProductItemDecoration())

        return view
    }

}