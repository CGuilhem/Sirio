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

class SearchFragment(private val context: MainActivity) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater?.inflate(R.layout.search_fragment, container, false)

        return view
    }
}