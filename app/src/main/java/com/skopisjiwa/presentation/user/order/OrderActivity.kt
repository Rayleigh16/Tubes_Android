package com.skopisjiwa.presentation.user.order

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.skopisjiwa.R
import com.skopisjiwa.data.order.PaymentSpinner
import com.skopisjiwa.data.product.OrderSummaryModel
import com.skopisjiwa.databinding.ActivityOrderBinding
import com.skopisjiwa.presentation.user.order.adapter.PaymentSpinnerAdapter
import com.skopisjiwa.presentation.user.order.adapter.SummaryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderActivity : AppCompatActivity() {

    private lateinit var summaryAdapter: SummaryAdapter
    private lateinit var listSummary: ArrayList<OrderSummaryModel>
    private lateinit var paymentAdapter: PaymentSpinnerAdapter
    private lateinit var list: ArrayList<PaymentSpinner>
    private lateinit var binding: ActivityOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()

        val spinner = binding.spinner
        paymentAdapter = PaymentSpinnerAdapter(this, list)
        spinner.adapter = paymentAdapter


        //        configure payemnt method
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val clickedItem = parent?.getItemAtPosition(position) as PaymentSpinner
                val clickedPaymentName = clickedItem.paymentName
                Toast.makeText(
                    this@OrderActivity,
                    "$clickedPaymentName selected",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        //       end configure payemnt method


//        sumarry prodcut item rv
//        DUMMY ORDER DATA
        listSummary =
            arrayListOf(
                OrderSummaryModel(1, "aqua", 12000, "Medium", 12000, "Cold", "low"),
                OrderSummaryModel(2, "Mineral", 12000, "Medium", 12000, "Cold", "low")
            )

        binding.rvOrderSummary.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvOrderSummary.setHasFixedSize(true)
        summaryAdapter = SummaryAdapter(listSummary)
        binding.rvOrderSummary.adapter = summaryAdapter

        //       end  sumarry prodcut item rv
        binding.btnPlaceOrder.setOnClickListener {
            val intent = Intent(this@OrderActivity, OrderFinishActivity::class.java)
            startActivity(intent)
        }



        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

    }


    private fun initList() {
        list = ArrayList()
        list.add(PaymentSpinner("Dana", R.drawable.ic_dana))
        list.add(PaymentSpinner("Ovo", R.drawable.ic_ovo))
        list.add(PaymentSpinner("Flip", R.drawable.ic_flip))
        list.add(PaymentSpinner("Cash", R.drawable.ic_cash))
        list.add(PaymentSpinner("Link Aja", R.drawable.ic_linkaja))

    }
}