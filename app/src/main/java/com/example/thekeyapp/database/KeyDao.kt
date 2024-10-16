package com.example.thekeyapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.thekeyapp.model.Key

@Dao
interface KeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKey(key: Key)

    @Update
    suspend fun updateKey(key: Key)

    @Delete
    suspend fun deleteKey(key: Key)

    @Query("SELECT * FROM KEYS ORDER BY id DESC")
    fun getAllKeys(): LiveData<List<Key>>

    //@Query("SELECT * FROM KEYS WHERE keyName LIKE :query OR keyDesc LIKE :query")
    //fun searchKey(query: String?): LiveData<List<Key>>
}