package com.example.thekeyapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "keys")
@Parcelize
data class Key(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val keyName: String,
    val keyDesc: String
): Parcelable
