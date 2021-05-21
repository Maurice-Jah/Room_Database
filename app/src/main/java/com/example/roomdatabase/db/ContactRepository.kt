package com.example.roomdatabase.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.roomdatabase.db.entities.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactRespository(context: Context) {
    private val db = ContactDatabase.invoke(context)

    fun getAllNotes():LiveData<List<NoteEntity>> = db.noteDao().selectAll()

    fun insertContact(noteEntity: NoteEntity){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                db.noteDao().insertNotes(noteEntity)
            }
        }
    }
}