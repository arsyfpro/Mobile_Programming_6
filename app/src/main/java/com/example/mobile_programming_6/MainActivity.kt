 package com.example.mobile_programming_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile_programming_6.adapter.CatListAdapter
import com.example.mobile_programming_6.data.CatData
import com.example.mobile_programming_6.data.CatItem
import com.example.mobile_programming_6.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var catList: ArrayList<CatItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // build the recylcerView via this function
        buildRecycleView()
    }

    // Define the EventHandler OnClickListener for the RV
     private fun catItemClicked(cat: CatItem) {
         startActivity(
             Intent(this@MainActivity, DetailActivity::class.java)
                 .putExtra("cat_detail", cat)
         )
     }

    // function to retrieve the Data from the companion object
    private fun retrieveCatsData(): ArrayList<CatItem> {
        val list: ArrayList<CatItem> = arrayListOf()
        list.addAll(CatData.listData)

        return list
    }

    private fun buildRecycleView() {
        // retrieve the Data from the companion object
        catList = retrieveCatsData()

        // initialize the adapter,
        // and pass the required argument, here is the data
        // and also, set the OnClickEventListener
        val catAdapter = CatListAdapter(catList) { cat: CatItem ->
            catItemClicked(cat)
        }
        // attach adapter to the recycler view
        binding.rvCats.adapter = catAdapter
        // create  layoutManager and pass it to rvCats layoutManager
        binding.rvCats.layoutManager = LinearLayoutManager(this@MainActivity,
            LinearLayoutManager.VERTICAL, false)
    }
 }