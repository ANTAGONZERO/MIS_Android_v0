package com.example.mis1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// SecondFragment.java


class loginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Your layout for SecondFragment goes here
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
}

