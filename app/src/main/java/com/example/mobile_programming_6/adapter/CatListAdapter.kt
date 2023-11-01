package com.example.mobile_programming_6.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_programming_6.data.CatItem
import com.example.mobile_programming_6.databinding.CatItemBinding

class CatListAdapter(
    private val cats: ArrayList<CatItem>,
    val itemClickListener: (CatItem) -> Unit
): RecyclerView.Adapter<CatListAdapter.CatViewHolder>() {

    // create an inner class with name CatViewHolder
    // It takes a view argument, in which pass the generated class of cat_item.xml
    // ie CatItemBinding and in the RecyclerView.ViewHolder(binding.root) pass it like this
    inner class CatViewHolder(val binding: CatItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        // bind the items with each item of the list cats ArrayList<CatItem>
        // which than will be shown in recycler view
        fun bind(cat: CatItem) = with(binding) {
            ivCat.setImageResource(cat.catImage)
            tvCatName.text = cat.catName
            root.setOnClickListener { itemClickListener(cat) }
        }
    }

    // inside the onCreateViewHolder inflate the view of CatItemBinding
    // and return new ViewHolder object containing this layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = CatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CatViewHolder(binding)
    }

    // in OnBindViewHolder this is where we get the current item
    // and bind it to the layout
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = cats[position]
        holder.bind(cat)
    }

    // return the size of cats ArrayList<CatItem>
    override fun getItemCount() = cats.size
}