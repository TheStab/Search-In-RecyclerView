package com.example.twelfthtask

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var animalsList : ArrayList<Animals>
    private lateinit var animalsAdapter : AnimalsAdapter
    private lateinit var searchView : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = findViewById(R.id.searchViewID)
        recyclerView = findViewById(R.id.recyclerViewID)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        animalsList = ArrayList()

        animalsList.add(Animals(R.drawable.dog, "Dog", getString(R.string.dog)))
        animalsList.add(Animals(R.drawable.chamelion, "Chameleon", getString(R.string.chameleon)))
        animalsList.add(Animals(R.drawable.dinosaur, "Dinosaur", getString(R.string.dinosaur)))
        animalsList.add(Animals(R.drawable.snake, "Snake", getString(R.string.snake)))
        animalsList.add(Animals(R.drawable.spider, "Spider", getString(R.string.spider)))

        animalsAdapter = AnimalsAdapter(animalsList)
        recyclerView.adapter = animalsAdapter



        animalsAdapter.onItemClick = {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("animals", it)
            startActivity(intent)
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
//                searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                filterFun(newText)

                return false
            }

        })
    }

    private fun filterFun(newText: String?) {
        val filteredList: ArrayList<Animals> = ArrayList()
        for (item in animalsList)
            if (item.title.lowercase().contains(newText.toString().lowercase()))
                filteredList.add(item)
        if (filteredList.isEmpty())
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show()
        else animalsAdapter.filterList(filteredList)
    }
}
