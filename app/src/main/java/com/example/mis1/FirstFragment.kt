package com.example.mis1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)

        view.findViewById<View>(R.id.loginBtn).setOnClickListener { v: View? ->
            // Navigate to the SecondFragment
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SecondFragment())
                .addToBackStack(null)
                .commit()
        }

        view.findViewById<View>(R.id.registerBtn).setOnClickListener { v: View? ->
            // Navigate to the ThirdFragment
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ThirdFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}