package com.duarte.gta_siro_mobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.duarte.gta_siro_mobile.MainActivity
import com.duarte.gta_siro_mobile.ProductViewModel
import com.duarte.gta_siro_mobile.R
import com.duarte.gta_siro_mobile.adapter.ProductAdapter
import com.duarte.gta_siro_mobile.model.ProductModel

class HomeFragment(private val context : MainActivity, productsList : List<ProductModel>) : Fragment() {
    val productList = productsList
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Création d'une liste qui stock les produits
//Enregistrement d'un premier produit dans la liste (bureau)
        val tabImage = arrayListOf<String>()
        tabImage.add("https://cdn.pixabay.com/photo/2017/08/01/23/51/apple-2568755_960_720.jpg")
        tabImage.add("https://cdn.pixabay.com/photo/2017/08/03/15/38/architecture-2576906_960_720.jpg")

//        productList.add(
//            ProductModel(
//                "Bureau",
//                "45,12",
//                "https://cdn.pixabay.com/photo/2017/08/01/23/51/apple-2568755_960_720.jpg",
//                "https://cdn.pixabay.com/photo/2017/08/01/23/51/apple-2568755_960_720.jpg",
//                tabImage
//            )
//        )
//
////Enregistrement d'un deuxième produit dans la liste (bureau)
//        productList.add(
//            ProductModel(
//                "Chaise",
//                "180,99",
//                "https://cdn.pixabay.com/photo/2017/08/03/15/38/architecture-2576906_960_720.jpg",
//                "https://cdn.pixabay.com/photo/2017/08/03/15/38/architecture-2576906_960_720.jpg",
//                tabImage
//            )
//        )
//
////Enregistrement d'un troisième produit dans la liste (bureau)
//        productList.add(
//            ProductModel(
//                "Bureau 2",
//                "50,85",
//                "https://cdn.pixabay.com/photo/2017/08/01/23/51/apple-2568755_960_720.jpg",
//                "https://cdn.pixabay.com/photo/2017/08/01/23/51/apple-2568755_960_720.jpg",
//                tabImage
//            )
//        )
//
////Enregistrement d'un quatrième produit dans la liste (bureau)
//        productList.add(
//            ProductModel(
//                "Chaise 2",
//                "149,99",
//                "https://cdn.pixabay.com/photo/2017/08/03/15/38/architecture-2576906_960_720.jpg",
//                "https://cdn.pixabay.com/photo/2017/08/03/15/38/architecture-2576906_960_720.jpg",
//                tabImage
//            )
//        )

        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.verticalRecyclerView)

        //Charger les plantes
        verticalRecyclerView.adapter = ProductAdapter(context, productList, R.layout.item_vertical_product)

        return view
    }
}

////Enregistrement d'un premier produit dans la liste (bureau)
//productList.add(
//ProductModel(
//"Bureau",
//"45,12",
//"https://cdn.pixabay.com/photo/2017/08/01/23/51/apple-2568755_960_720.jpg",
//false
//)
//)
//
////Enregistrement d'un deuxième produit dans la liste (bureau)
//productList.add(
//ProductModel(
//"Chaise",
//"180,99",
//"https://cdn.pixabay.com/photo/2017/08/03/15/38/architecture-2576906_960_720.jpg",
//true
//)
//)
//
////Enregistrement d'un troisième produit dans la liste (bureau)
//productList.add(
//ProductModel(
//"Bureau 2",
//"50,85",
//"https://cdn.pixabay.com/photo/2017/08/01/23/51/apple-2568755_960_720.jpg",
//false
//)
//)
//
////Enregistrement d'un quatrième produit dans la liste (bureau)
//productList.add(
//ProductModel(
//"Chaise 2",
//"149,99",
//"https://cdn.pixabay.com/photo/2017/08/03/15/38/architecture-2576906_960_720.jpg",
//false
//)
//)