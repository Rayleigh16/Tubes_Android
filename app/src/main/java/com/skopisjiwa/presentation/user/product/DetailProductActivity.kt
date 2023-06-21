package com.skopisjiwa.presentation.user.product

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.skopisjiwa.data.product.OptionRadioButton
import com.skopisjiwa.data.product.ProductModel
import com.skopisjiwa.databinding.ActivityDetailProductBinding
import com.skopisjiwa.presentation.user.order.OrderActivity
import com.skopisjiwa.presentation.user.product.adapter.RadioButtonAdapter
import com.skopisjiwa.utils.ConvertStringPrice
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProductBinding

    private lateinit var received: ProductModel
    private lateinit var radioButtonAdapter: RadioButtonAdapter
    private lateinit var radioButonSize: ArrayList<OptionRadioButton>
    private lateinit var radioAvailable: ArrayList<OptionRadioButton>
    private lateinit var radioSugarLevel: ArrayList<OptionRadioButton>


    private var quantity: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        received = intent.getParcelableExtra("data_produk")!!


        radioButonSize = arrayListOf(
            OptionRadioButton("Small", 0),
            OptionRadioButton("Medium", 3000),
            OptionRadioButton("Large", 4000),
        )


        radioAvailable = arrayListOf(
            OptionRadioButton("Hot", 0),
            OptionRadioButton("Cold", 0),
        )


        radioSugarLevel = arrayListOf(
            OptionRadioButton("Less sugar", 0),
            OptionRadioButton("Normal", 0),
        )

//        size option
        binding.rvOptionSize.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvOptionSize.setHasFixedSize(true)
        radioButtonAdapter = RadioButtonAdapter(radioButonSize)
        binding.rvOptionSize.adapter = radioButtonAdapter


//        option available
        binding.rvOptionAvailable.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvOptionAvailable.setHasFixedSize(true)
        radioButtonAdapter = RadioButtonAdapter(radioAvailable)
        binding.rvOptionAvailable.adapter = radioButtonAdapter


//option sugar level
        binding.rvOptionSugar.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvOptionSugar.setHasFixedSize(true)
        radioButtonAdapter = RadioButtonAdapter(radioSugarLevel)
        binding.rvOptionSugar.adapter = radioButtonAdapter


//        get selectedRadionButtonSize
        val selectedPositionSize = radioButtonAdapter.getSelectedPosition()
        if (selectedPositionSize != -1) {
            val seletedSize = radioButonSize[selectedPositionSize]

            val hargaTambahan = seletedSize.price
//            doing action with harga tambahan  to order addchart total

        }


        //        get selectedRadionButtonAvailable
        val selectedPositioAvailable = radioButtonAdapter.getSelectedPosition()
        if (selectedPositioAvailable != -1) {
            val seletedAvailable = radioAvailable[selectedPositioAvailable]

            val hargaTambahan = seletedAvailable.price
//            doing action with harga tambahan  to order addchart total

        }


        //        get selectedRadionButton sugar level
        val selectedPositionSugar = radioButtonAdapter.getSelectedPosition()
        if (selectedPositionSugar != -1) {
            val seletedSize = radioSugarLevel[selectedPositionSugar]

            val hargaTambahan = seletedSize.price
//            doing action with harga tambahan  to order addchart total
        }




        binding.btnCloseDetail.setOnClickListener {
            onBackPressed()
        }

        val convertPrice = ConvertStringPrice.convertToCurrencyFormat(received.hargaProduk)
        binding.tvTotal.text = convertPrice


//      increase dicrease item produk
        binding.btnPlusQuntity.setOnClickListener {
            quantity++
            binding.tvTotalItem.text = quantity.toString()
        }

        binding.btnMinusQuantity.setOnClickListener {
            if (quantity > 1) {
                quantity--
                binding.tvTotalItem.text = quantity.toString()
            } else {
                quantity = 1
            }
        }

        binding.btnToChart.setOnClickListener {
            val intent = Intent(this@DetailProductActivity, OrderActivity::class.java)
            startActivity(intent)
        }
    }
}