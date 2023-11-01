package com.example.mobile_programming_6.data

// import the parcelable package
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// initialize the CatItem's data structure
@Parcelize
data class CatItem(
    val catImage : Int,
    val catName : String
) : Parcelable
