package com.example.roomdatabase.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.db.dao.NoteDao
import com.example.roomdatabase.db.entities.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object{
        @Volatile private var instance: ContactDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,ContactDatabase::class.java, "contact.db").build()
    }
}