package com.example.ktwishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview20.CustomAdapter.CustomViewHolder

class CustomAdapter( var userData: List<UserData>) : RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.nameText.text = userData[position].name
        holder.priceText.text = userData[position].price
        holder.urlText.text = userData[position].url
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameText: TextView
        var priceText: TextView
        var urlText: TextView

        init {
            nameText = itemView.findViewById(R.id.nameText)
            priceText = itemView.findViewById(R.id.priceText)
            urlText = itemView.findViewById(R.id.urlText)
        }
    }
}
