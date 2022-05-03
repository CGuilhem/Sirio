package com.duarte.gta_siro_mobile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.duarte.gta_siro_mobile.model.ProductModel
import java.lang.Exception
import kotlin.concurrent.thread

class ProductViewModel : ViewModel() {

    var data = MutableLiveData<List<ProductModel>>()
    var errorMessage = MutableLiveData<String?>()

    fun loadData() {
        //Reset des données
        data.postValue(null)
        errorMessage.postValue(null)

        thread {

            try {
                data.postValue(RequestUtils.loadAllProducts())

            } catch (e: Exception) {
                errorMessage.postValue("Erreur : ${e.message}")
                e.printStackTrace()
            }
        }
    }
}