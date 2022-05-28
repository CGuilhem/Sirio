package com.duarte.gta_siro_mobile.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.duarte.gta_siro_mobile.MainActivity
import com.duarte.gta_siro_mobile.ProductPopup
import com.duarte.gta_siro_mobile.R
import com.duarte.gta_siro_mobile.RequestUtils
import com.duarte.gta_siro_mobile.model.ProductModel
import com.google.gson.JsonParser
import org.json.JSONObject

class ProductAdapter(val context: MainActivity, private val productList: List<ProductModel>, private val layoutId: Int) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    //Boite permettant de ranger les composants
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //Image du produit
//        val productPicture = view.findViewById<ImageView>(R.id.imageItem)

        //Nom du produit en lien avec le layout
        val productName: TextView? = view.findViewById<TextView>(R.id.textViewProductName)
        val productPrice: TextView? = view.findViewById<TextView>(R.id.textViewProductPrice)
        val productPictureSquare  = view.findViewById<ImageView>(R.id.imageItem)
        val productPictureLine  = view.findViewById<ImageView>(R.id.imageItem_Product_Line)
        val productPicturePopup  = view.findViewById<ImageView>(R.id.imageItem_Product)
        val favoriteIcon = view.findViewById<ImageView>(R.id.imageViewFavorite)
        val cartIcon = view.findViewById<ImageView>(R.id.add_cart_button)
        val buttonSignIn = view.findViewById<ImageView>(R.id.connexionButton)

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
        if (holder.productPictureSquare != null) {
            Glide.with(context).load(Uri.parse(currentProduct.imagesUrl[0]))
                .into(holder.productPictureSquare) //Uri.parse() permet de convertir l'url de l'image en une action android
        }else if (holder.productPictureLine != null) {
            Glide.with(context).load(Uri.parse(currentProduct.imagesUrl[0]))
                .into(holder.productPictureLine) //Uri.parse() permet de convertir l'url de l'image en une action android
        }else if (holder.productPicturePopup != null) {
            Glide.with(context).load(Uri.parse(currentProduct.imagesUrl[0]))
                .into(holder.productPicturePopup) //Uri.parse() permet de convertir l'url de l'image en une action android
        }
        //Mettre à jour le nom du produit
        holder.productName?.text = currentProduct.nom

        //Mise à jour du prix
        holder.productPrice?.text = currentProduct.prix.toString()

//      Vérifier si le produit est liké
        if (currentProduct.liked) {
            holder.favoriteIcon?.setImageResource(R.drawable.ic__favorite_red_24)

        } else {
            holder.favoriteIcon?.setImageResource(R.drawable.ic_not_favorite)

        }

//      Vérifier si le produit est ajouté au panier
        if (currentProduct.addedToCart) {
            holder.cartIcon?.setImageResource(R.drawable.ic_remove_from_cart)
        } else {
            holder.cartIcon?.setImageResource(R.drawable.ic_add_in_cart)
        }

//        Interaction sur le bouton like
        holder.favoriteIcon?.setOnClickListener {
            //Inverse ou non si le bouton est like ou pas
            currentProduct.liked = !currentProduct.liked
            if(currentProduct.liked == true){
                val toast = Toast.makeText(context, "Product add to favorites", Toast.LENGTH_SHORT)
                toast.show()
            }else if(currentProduct.liked == false){
                val toast = Toast.makeText(context, "Product remove from favorites", Toast.LENGTH_SHORT)
                toast.show()
            }
            //Met à jour l'objet produit ??
        }

//      Interaction sur le bouton panier
        holder.cartIcon?.setOnClickListener {
            //Inverse ou non si le bouton est like ou pas
            currentProduct.addedToCart = !currentProduct.addedToCart
            //Met à jour l'objet produit ??
            if(currentProduct.addedToCart == true){
                val toast = Toast.makeText(context, "Product add to cart", Toast.LENGTH_SHORT)
                toast.show()
            }else if(currentProduct.addedToCart == false){
                val toast = Toast.makeText(context, "Product remove from cart", Toast.LENGTH_SHORT)
                toast.show()
            }
        }


        //Interaction lors du click sur un produit (popup)
        holder.itemView.setOnClickListener {
            //affichage de la popup
            ProductPopup(this, currentProduct).show()
        }
        //Bouton Connexion
//        holder.buttonSignIn.setOnClickListener {
//            val jsonCreation : JSONObject? = JSONObject("""{"email":"guilhemcalonne@yahoo.fr", "password":test}""")
//            RequestUtils.post(jsonCreation)
//        }
        /* FORME DU JSON
            {
              email: «machin »,
              password: « machin »
            }
        */

    }

    //Permet de générer le nombre d'item désiré
    override fun getItemCount(): Int = productList.size
}