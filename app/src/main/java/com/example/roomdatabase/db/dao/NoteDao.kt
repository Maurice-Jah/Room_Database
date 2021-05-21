package com.example.roomdatabase.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdatabase.db.entities.NoteEntity

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun selectAll(): LiveData<List<NoteEntity>>

    @Insert
    fun insertNotes(noteEntity: NoteEntity)

    @Delete
    fun deleteNotes(noteEntity: NoteEntity)

    @Update
    fun updateNotes(noteEntity: NoteEntity)
}