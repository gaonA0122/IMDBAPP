package com.example.imdbapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ItemAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>(), Filterable {

    private var filteredList: List<Item> = itemList

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewYear: TextView = itemView.findViewById(R.id.textViewYear)
        val textViewActors: TextView = itemView.findViewById(R.id.textViewActors)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filteredList[position]

        val drawableId = ContextCompat.getDrawable(holder.itemView.context, item.imageUrl)
        holder.imageView.setImageDrawable(drawableId)

        holder.textViewName.text = item.name
        holder.textViewYear.text = "Año: ${item.year}"
        holder.textViewActors.text = "Actores: ${item.actors}"
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString().toLowerCase(Locale.getDefault())
                filteredList = if (charSearch.isEmpty()) {
                    itemList
                } else {
                    itemList.filter { it.name.toLowerCase(Locale.getDefault()).contains(charSearch) }
                }

                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as? List<Item> ?: emptyList()
                notifyDataSetChanged()
            }
        }
    }
}

