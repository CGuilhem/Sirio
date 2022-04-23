package com.duarte.gta_siro_mobile.model

import com.google.gson.annotations.SerializedName

data class ProductModel (
    @SerializedName("_id") val id : String = "id",
    @SerializedName("nom") val name : String = "Meuble",
    @SerializedName("categorie") val category : String = "Not available",
    @SerializedName("description") val description : String = "Not available",
    @SerializedName("imagesUrl") val imageUrl : List<String>,
    @SerializedName("prix") val price : String = "Not available",
    @SerializedName("stock") val stock : Int = 0,
    @SerializedName("note") val rate : Int = 0,
    @SerializedName("userId") val userId: String = "Null",
    var liked : Boolean = false
)