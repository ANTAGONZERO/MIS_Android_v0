package com.example.mis1
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class NewProjectFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Your layout for SecondFragment goes here
        return inflater.inflate(com.example.mis1.R.layout.fragment_new_project, container, false)
    }
}