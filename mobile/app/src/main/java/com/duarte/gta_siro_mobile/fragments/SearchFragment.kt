package com.duarte.gta_siro_mobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.duarte.gta_siro_mobile.MainActivity
import com.duarte.gta_siro_mobile.R

class SearchFragment(private val context: MainActivity) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater?.inflate(R.layout.fragment_favorites, container, false)

        return view
    }
}