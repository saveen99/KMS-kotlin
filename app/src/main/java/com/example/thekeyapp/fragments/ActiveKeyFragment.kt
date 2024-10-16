package com.example.thekeyapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import com.example.thekeyapp.R
import com.example.thekeyapp.adapter.KeyAdapter
import com.example.thekeyapp.databinding.FragmentActiveKeyDetailsBinding
import com.example.thekeyapp.viewmodel.KeyViewModel


class ActiveKeyFragment : Fragment(R.layout.fragment_active_key) {

    private var activeBinding: FragmentActiveKeyBinding? = null
    private val binding get() = activeBinding!!

    private lateinit var keysViewModel: KeyViewModel
    private lateinit var keyAdapter: KeyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activeBinding = FragmentActiveKeyBinding.inflate(inflater, container, false)
        return binding.root
    }

}