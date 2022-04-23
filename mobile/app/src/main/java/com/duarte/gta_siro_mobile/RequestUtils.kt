package com.duarte.gta_siro_mobile

import com.duarte.gta_siro_mobile.model.ProductModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

//Sur le réseau quand Guilhem fait serveur
//private const val URL_API_SEARCH = "http://192.168.20.149:3000/api/meuble"
//En local que je suis chez moi
private const val URL_API_SEARCH = "http://192.168.56.1:3000/api/meuble"

class RequestUtils {
    companion object {
        private val client = OkHttpClient()

        inline fun <reified T> Gson.fromJson(json: String) = fromJson<T>(json, object : TypeToken<T>() {}.type)

        fun loadAllProducts(): List<ProductModel> {
            val json = sendGet("$URL_API_SEARCH")
            println("JSON :" + json)
            //Parser le JSON avec le bon bean et GSON
            //val productList:List<ProductModel> = Gson().fromJson<List<ProductModel>>(json)

            var productList = Json.decodeFromString<List<ProductModel>>(json)

            //val productList = Gson().fromJson(json, Array<ProductModel>::class.java).asList()
            println("JSON CONVERTED :"+ productList)
//            val data = Gson().fromJson(json, ProductModel::class.java)
            //Retourner la donnée
//            println("DATA :" + data)
            return productList
        }

        fun sendGet(url: String): String {
            //Création de la requete
            println("url : $url")
            val request = Request.Builder()
                .url(url)
                .get()
                .build()
            //Execution de la requête
            val response = client.newCall(request).execute()
            //Analyse du code retour
            return if (response.code !in 200..299) {
                throw Exception("Réponse du serveur incorrect : ${response.code}")
            } else {
                //Résultat de la requete.
                response.body?.string() ?: ""
            }
        }
    }
}
