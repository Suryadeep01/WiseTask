package com.example.wisetask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisetask.adapter.Adapter
import com.example.wisetask.model.response.Cocktail
import com.example.wisetask.viewModel.mojitoViewModel


class MainActivity : AppCompatActivity() {

    lateinit var mojitoInitViewModel: mojitoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData("rum")



        val searchView = findViewById<SearchView>(R.id.searchView)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                loadData(query)

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val searchText = newText.orEmpty()
                return true
            }
        })

    }

    fun loadData(query: String?) {
        mojitoInitViewModel = ViewModelProvider(this).get(mojitoViewModel::class.java)
        mojitoInitViewModel.getApiData(query)
        mojitoInitViewModel.mojitoDataList.observe(this, Observer {
            initAdapter(it)
        })
    }

    private fun initAdapter(cocktailList: List<Cocktail>) {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerVi)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // Change 2 to the number of columns you want
        recyclerView.adapter = Adapter(cocktailList)
    }
}
