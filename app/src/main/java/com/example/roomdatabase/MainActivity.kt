package com.example.roomdatabase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.adapter.ContactAdapter
import com.example.roomdatabase.db.ContactRespository
import com.example.roomdatabase.db.entities.NoteEntity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var contactAdapter: ContactAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var contactRepository: ContactRespository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        contactAdapter = ContactAdapter()
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recyclerView)
        floatingActionButton = findViewById(R.id.floatingActionButton)

        recyclerView.adapter = contactAdapter

        recyclerView.layoutManager = linearLayoutManager

        contactRepository = ContactRespository(this)



        insertDataIntoDb()

        floatingActionButton.setOnClickListener{
            openAddContact()
        }
    }

    override fun onResume() {
        super.onResume()
        contactRepository.getAllNotes().observe(this,{ contacts ->
            contactAdapter.submitList(contacts)
        })
    }

    private fun openAddContact(){
        val intent = Intent(this,SignUp::class.java)
        startActivity(intent)
    }



    private fun insertDataIntoDb(){
        val noteEntity = NoteEntity(firstName = "Maurice",lastName = "Buchi",email = "maurice@gmail.com",password = "1234")
        contactRepository.insertContact(noteEntity)
        val noteEntity2 = NoteEntity(firstName = "Afezze",lastName = "Shauibu",email = "shauibu@gmail.com",password = "12345")
        contactRepository.insertContact(noteEntity2)
        val noteEntity3 = NoteEntity(firstName = "Michael",lastName = "Okiro",email = "maurice@yahoo.com",password = "5678")
        contactRepository.insertContact(noteEntity3)
        val noteEntity4 = NoteEntity(firstName = "Afezze",lastName = "Shaw",email = "shaw@gmail.com",password = "80000")
        contactRepository.insertContact(noteEntity4)

    }
}