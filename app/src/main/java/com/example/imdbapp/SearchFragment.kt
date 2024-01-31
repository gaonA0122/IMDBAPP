package com.example.imdbapp

// SearchFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_search_activity, container, false)

        val itemList = listOf(
            Item("Ladybug & Cat Noir: The Movie", R.drawable.miraculous, "2023", "Cristina vee, Bryce Papenbrook"),
            Item("Free Guy", R.mipmap.freeguy, "2021", "Ryan Reynolds"),
            Item("La Monja", R.drawable.nun, "2018", "Taissa Farmiga, Jonas Bloquet"),
            Item("The Queen's Gambit",R.drawable.the_queen, "2020", "Anya Taylor-joy, Harry Melling"),
        )

        recyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = ItemAdapter(itemList)
        recyclerView.adapter = adapter

        searchView = rootView.findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        return rootView
    }
}

/*private val allItems = listOf(
       Item("Ladybug & Cat Noir: The Movie", "2023", "Cristina vee, Bryce Papenbrook", R.drawable.miraculous),
       Item("Free Guy", "2021", "Ryan Reynolds", R.mipmap.freeguy),
       Item("La Monja", "2018", "Taissa Farmiga, Jonas Bloquet", R.drawable.nun),
       Item("Avatar: The Way of Water", "2022", "Sam Worthington", R.drawable.avatar),
       Item("The Queen's Gambit", "Anya Taylor-joy, Harry Melling", "2020", R.drawable.the_queen),
   )*/

