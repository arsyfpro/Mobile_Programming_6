package com.example.mobile_programming_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobile_programming_6.data.CatItem
import com.example.mobile_programming_6.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var cat: CatItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get the Parcelable intent
        cat = intent.getParcelableExtra("cat_detail")!!

        // bind the data from intent to the layout
        binding.ivCatDetail.setImageResource(cat.catImage)
        binding.tvCatDetail.text = cat.catName
    }
}