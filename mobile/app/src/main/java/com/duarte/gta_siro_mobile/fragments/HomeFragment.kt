package com.duarte.gta_siro_mobile.fragments

import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duarte.gta_siro_mobile.R
import com.duarte.gta_siro_mobile.adapter.ProductAdapter
import com.duarte.gta_siro_mobile.model.ProductModel

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Création d'une liste qui stock les produits
        val productList = arrayListOf<ProductModel>()

        //Enregistrement d'un premier produit dans la liste (bureau)
        productList.add(
            ProductModel(
            "Bureau",
            "Ceci est un superbe bureau",
            "https://cdn.pixabay.com/photo/2017/08/01/23/51/apple-2568755_960_720.jpg",
                false
        )
        )

        //Enregistrement d'un deuxième produit dans la liste (bureau)
        productList.add(
            ProductModel(
                "Chaise",
                "Ceci est une superbe chaise",
                "https://cdn.pixabay.com/photo/2017/08/03/15/38/architecture-2576906_960_720.jpg",
                false
            )
        )

        //Enregistrement d'un troisième produit dans la liste (bureau)
        productList.add(
            ProductModel(
                "Bureau 2",
                "Ceci est un superbe bureau",
                "https://cdn.pixabay.com/photo/2017/08/01/23/51/apple-2568755_960_720.jpg",
                false
            )
        )

        //Enregistrement d'un quatrième produit dans la liste (bureau)
        productList.add(
            ProductModel(
                "Chaise 2",
                "Ceci est une superbe chaise",
                "https://cdn.pixabay.com/photo/2017/08/03/15/38/architecture-2576906_960_720.jpg",
                false
            )
        )


        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.verticalRecyclerView)

        //Charger les plantes
        verticalRecyclerView.adapter = ProductAdapter(productList, R.layout.item_vertical_product)

        return view
    }
}