package com.skopisjiwa.data.store

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreModel(
    val id:String?=null,
    val image: String? = null,
    val titleStore: String? = null,
    val open: String? = null,
    val address: String? = null,
) : Parcelable


// tes untuk real data ke firebase pake model dibawah spya class yang pake model diatas tak error

//@Parcelize
//data class StoresModel(
//    val id: String? = null,
//    val image: String,
//    val titleStore: String,
//    val open: String,
//    val address: String,
//):Parcelable
