package com.example.thekeyapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thekeyapp.repository.KeyRepository

class KeyViewModelFactory(val app: Application, private val keyRepository: KeyRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return KeyViewModel(app, keyRepository) as T
    }

}