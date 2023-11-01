package com.example.mobile_programming_6.data

import com.example.mobile_programming_6.R

object CatData {
    // assign the cats' image
    private val catImage = arrayOf(
        R.drawable.yaqub_qomarudin_dibizah,
        R.drawable.ismail_ahmad_khan_nabawi,
        R.drawable.khidir_karawitah,
        R.drawable.utsman_abdul_jalil_shisha,
        R.drawable.khalid_kashmiri,
        R.drawable.muhammad_sumbul,
        R.drawable.tutu_taali,
        R.drawable.wisp,
        R.drawable.tater_tot,
        R.drawable.mohawk_kevin,
        R.drawable.panko,
        R.drawable.p_pito,
        R.drawable.benji
    )

    // assign the cats' name into an array
    private val catName = arrayOf(
        "Yaqub Qomarudin Dibizah",
        "Ismail Ahmad Khan Nabawi",
        "Khidir Karawitah",
        "Utsman Abdul Jalil Shisha",
        "Khalid Kashmiri",
        "Muhammad Sumbul",
        "Tutu Ta\'ali",
        "Wisp",
        "Tater Tot",
        "Mohawk Kevin",
        "Panko",
        "Pépito",
        "Benji"
    )

    //making immutable arraylist that returns information from the object
    val listData: ArrayList<CatItem>
        get() {
            val list = arrayListOf<CatItem>()

            for (pos in catName.indices) {
                val image = catImage[pos]
                val name = catName[pos]

                val cat = CatItem(image, name)

                list.add(cat)
            }

            return list
        }
}