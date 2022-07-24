package com.example.twelfthtask

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalsAdapter(private var animalsList:ArrayList<Animals>)
    : RecyclerView.Adapter<AnimalsAdapter.AnimalsViewHolder>(){

    var onItemClick : ((Animals) -> Unit)? = null

    class AnimalsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageViewID)
        val textView : TextView = itemView.findViewById(R.id.titleID)
        val description : TextView = itemView.findViewById(R.id.descriptionID)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return AnimalsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalsViewHolder, position: Int) {
        val animals = animalsList[position]
        holder.imageView.setImageResource(animals.image)
        holder.textView.text = animals.title
        holder.description.text = animals.description

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(animals)
        }
    }

    override fun getItemCount(): Int {
        return animalsList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filteredList: ArrayList<Animals>) {

            animalsList = filteredList
            notifyDataSetChanged()
    }
}