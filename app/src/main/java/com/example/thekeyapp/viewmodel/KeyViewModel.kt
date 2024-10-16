package com.example.thekeyapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.thekeyapp.model.Key
import com.example.thekeyapp.repository.KeyRepository
import kotlinx.coroutines.launch

class KeyViewModel(app: Application, private val keyRepository: KeyRepository) : AndroidViewModel(app)  {

    fun addKey(key: Key) = viewModelScope.launch {
        keyRepository.insertKey(key)
    }

    fun deleteKey(key: Key) = viewModelScope.launch {
        keyRepository.deleteKey(key)
    }

    fun updateKey(key: Key) = viewModelScope.launch {
        keyRepository.updateKey(key)
    }

    fun getAllKeys() = keyRepository.getAllKeys()

    //fun searchKeys(query: String) = keyRepository.searchKeys(query)

}