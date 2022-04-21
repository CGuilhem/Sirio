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
import com.duarte.gta_siro_mobile.model.ProductModel

class FavoritesFragment(private val context: MainActivity) : Fragment()  {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Création d'une liste qui stock les produits
        val productList = arrayListOf<ProductModel>()

//Enregistrement d'un premier produit dans la liste (bureau)
        productList.add(
            ProductModel(
                "Bureau",
                "45,12",
                "https://cdn.pixabay.com/photo/2017/08/01/23/51/apple-2568755_960_720.jpg",
                false
            )
        )

//Enregistrement d'un deuxième produit dans la liste (bureau)
        productList.add(
            ProductModel(
                "Chaise",
                "180,99",
                "https://cdn.pixabay.com/photo/2017/08/03/15/38/architecture-2576906_960_720.jpg",
                true
            )
        )

//Enregistrement d'un troisième produit dans la liste (bureau)
        productList.add(
            ProductModel(
                "Bureau 2",
                "50,85",
                "https://cdn.pixabay.com/photo/2017/08/01/23/51/apple-2568755_960_720.jpg",
                false
            )
        )

//Enregistrement d'un quatrième produit dans la liste (bureau)
        productList.add(
            ProductModel(
                "Chaise 2",
                "149,99",
                "https://cdn.pixabay.com/photo/2017/08/03/15/38/architecture-2576906_960_720.jpg",
                false
            )
        )

        val view = inflater?.inflate(R.layout.fragment_favorites, container, false)

        //Recupérer le recyclerView de favoris
        val favortitesRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_favorites)
        //ajouter le layout favorite_horizontal
        favortitesRecyclerView.adapter = ProductAdapter(context, productList.filter { it.liked } , R.layout.)
        favortitesRecyclerView.layoutManager = LinearLayoutManager(context)
        //Permet d'espacer les produits
        favortitesRecyclerView.addItemDecoration(ProductItemDecoration())

        return view
    }

}