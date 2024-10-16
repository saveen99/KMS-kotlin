package com.example.thekeyapp.repository

import androidx.room.Query
import com.example.thekeyapp.database.KeyDatabase
import com.example.thekeyapp.model.Key

class KeyRepository(private val db: KeyDatabase) {

    suspend fun insertKey(key: Key) = db.getKeyDao().insertKey(key)
    suspend fun deleteKey(key: Key) = db.getKeyDao().deleteKey(key)
    suspend fun updateKey(key: Key) = db.getKeyDao().updateKey(key)

    fun getAllKeys() = db.getKeyDao().getAllKeys()
    //fun searchNote(query: String?) = db.getKeyDao().searchKey(query)
}