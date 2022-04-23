package com.duarte.gta_siro_mobile

import android.util.JsonReader
import com.duarte.gta_siro_mobile.model.ProductModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import java.io.StringReader
//Sur le réseau quand Guilhem fait serveur
//private const val URL_API_SEARCH = "http://192.168.20.149:3000/api/meuble"
//En local que je suis chez moi
private const val URL_API_SEARCH = "http://localhost:3000/api/meuble"

class RequestUtils {
    companion object {
        private val client = OkHttpClient()

        fun loadAllProducts(): ArrayList<ProductModel> {
            val json =
                sendGet("$URL_API_SEARCH")
            //Parser le JSON avec le bon bean et GSON
            println("JSON :" + json)

            val productList:ArrayList<ProductModel> = Gson().fromJson<ArrayList<ProductModel>>(json)
            print("JSON CONVERTED :"+ productList)
//            val data = Gson().fromJson(json, ProductModel::class.java)
            //Retourner la donnée
//            println("DATA :" + data)
            return productList
        }
        inline fun <reified T> Gson.fromJson(json: String) = fromJson<T>(json, object : TypeToken<T>() {}.type)

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
