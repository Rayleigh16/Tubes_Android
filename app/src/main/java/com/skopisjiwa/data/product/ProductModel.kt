package com.skopisjiwa.data.product

import android.os.Parcel
import android.os.Parcelable
import android.widget.RadioButton
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(
    val nameProduk: String,
    val gambarProduk: Int,
    val hargaProduk: Int
) : Parcelable

@Parcelize
data class OptionRadioButton(
    val size: String,
    val price: Int,
) : Parcelable

@Parcelize
data class OrderSummaryModel(
    val number: Int,
    val nameProduk: String,
    val hargaProduk: Int,
    val sizeProduk: String,
    val tambahanHargaSize: Int,
    val availableProduk: String,
    val sugarLevelDrink: String
) : Parcelable