package com.duarte.gta_siro_mobile.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ProductModel (
    @SerializedName("_id") val _id : String = "id",
    @SerializedName("nom") val nom : String = "Meuble",
    @SerializedName("categorie") val categorie : String = "Not available",
    @SerializedName("description") val description : String = "Not available",
    @SerializedName("imagesUrl") val imagesUrl : List<String>,
    @SerializedName("prix") val prix : Double = 0.0,
    @SerializedName("stock") val stock : Int = 0,
    @SerializedName("note") val note : Double = 0.0,
    @SerializedName("userId") val userId: String = "Null",
    var liked : Boolean = false
)