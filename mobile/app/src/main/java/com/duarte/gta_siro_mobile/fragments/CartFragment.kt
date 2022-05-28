package com.duarte.gta_siro_mobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duarte.gta_siro_mobile.MainActivity
import com.duarte.gta_siro_mobile.R
import com.duarte.gta_siro_mobile.adapter.ProductAdapter
import com.duarte.gta_siro_mobile.adapter.ProductItemDecoration
import com.duarte.gta_siro_mobile.model.ProductModel

class CartFragment(private val context: MainActivity, productsList : List<ProductModel>) : Fragment()  {
    val productList = productsList

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater?.inflate(R.layout.fragment_cart, container, false)

        //Recupérer le recyclerView du panier
        val cartRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_cart_VerticalList)

        cartRecyclerView?.adapter = ProductAdapter(context, productList.filter { it.addedToCart }, R.layout.item_horizontal_info_product)
        cartRecyclerView.layoutManager = LinearLayoutManager(context)

        //Permet d'espacer les produits
        cartRecyclerView.addItemDecoration(ProductItemDecoration())
        return view
    }
}