package com.example.roomdatabase.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var id :Int = 0,
    var firstName : String,
    var lastName: String,
    var email: String,
    var password: String
)
