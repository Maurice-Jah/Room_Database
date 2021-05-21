package com.example.roomdatabase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.db.entities.NoteEntity

class ContactAdapter:ListAdapter<NoteEntity,ContactAdapter.ContactViewHolder>(ContactDiffUtil()) {

    inner class ContactViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        fun bind(
            item : NoteEntity
        ){
            val contactFirstName:TextView = itemView.findViewById(R.id.firstnameEt)
            val contactLastName:TextView = itemView.findViewById(R.id.lastnameET)
            val contactEmail:TextView = itemView.findViewById(R.id.emailET)
            val contactPassword:TextView = itemView.findViewById(R.id.passwordEt)

            contactFirstName.text = item.firstName
            contactLastName.text = item.lastName
            contactEmail.text = item.email
            contactPassword.text = item.password
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_contact_rv,parent,false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}


class  ContactDiffUtil: DiffUtil.ItemCallback<NoteEntity>(){
    override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
      return oldItem.id == newItem.id
    }

}