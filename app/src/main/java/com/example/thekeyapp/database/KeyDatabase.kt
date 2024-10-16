package com.example.thekeyapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.thekeyapp.model.Key

@Database(entities = [Key::class], version = 1)
abstract class KeyDatabase: RoomDatabase() {
    abstract fun getKeyDao(): KeyDao

    companion object{
        @Volatile
        private var instance: KeyDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?:
        synchronized(LOCK){
            instance ?:
            createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                KeyDatabase::class.java,
                name = "key_db"
            ).build()
    }
}