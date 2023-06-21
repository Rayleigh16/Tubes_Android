package com.skopisjiwa.presentation.user.product

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.skopisjiwa.R
import com.skopisjiwa.data.product.ProductModel
import com.skopisjiwa.data.store.StoreModel
import com.skopisjiwa.databinding.ActivityListProductBinding

import com.skopisjiwa.presentation.user.product.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListProductActivity : AppCompatActivity(), ProductAdapter.CellClickListener {


    private lateinit var binding: ActivityListProductBinding
    private lateinit var received: StoreModel
    private lateinit var adapter: ProductAdapter
    private lateinit var list: ArrayList<ProductModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        list = arrayListOf(
            ProductModel(
                "Air jiwa",
                R.drawable.produk_late, 12000
            ),
            ProductModel(
                "Air jiwa",
                R.drawable.produk_late, 12000
            ),
            ProductModel(
                "Kopi Susu",
                R.drawable.kopi_susu, 25000
            ),
            ProductModel(
                "Air Jiwa",
                R.drawable.produk_late, 12000
            ),
            ProductModel(
                "Kopi Susu Wuenak",
                R.drawable.kopi_susu, 35000
            ),
            ProductModel(
                "Kopi Susu Wuenak",
                R.drawable.kopi_susu, 35000
            ),
            ProductModel(
                "Kopi Susu Wuenak",
                R.drawable.kopi_susu, 35000
            ),
            ProductModel(
                "Kopi Susu Wuenak",
                R.drawable.kopi_susu, 35000
            ),
            ProductModel(
                "Kopi Susu Wuenak",
                R.drawable.kopi_susu, 35000
            ),
        )


        val intent: Intent = intent
        received = intent.getParcelableExtra("data_store")!!
        binding = ActivityListProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLocation.text = received.titleStore
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

//        new release
        binding.rvNewRelease.layoutManager = GridLayoutManager(applicationContext, 2)
        binding.rvNewRelease.setHasFixedSize(true)
        adapter = ProductAdapter(list, this)
        binding.rvNewRelease.adapter = adapter


//        kopi signature
        binding.rvKopiSignature.layoutManager = GridLayoutManager(applicationContext, 2)
        binding.rvKopiSignature.setHasFixedSize(true)
        adapter = ProductAdapter(list,this)
        binding.rvKopiSignature.adapter = adapter

//        non cofee
        binding.rvNonCofee.layoutManager = GridLayoutManager(applicationContext, 2)
        binding.rvNonCofee.setHasFixedSize(true)
        adapter = ProductAdapter(list,this)
        binding.rvNonCofee.adapter = adapter

//        Snack
        binding.rvSnack.layoutManager = GridLayoutManager(applicationContext, 2)
        binding.rvSnack.setHasFixedSize(true)
        adapter = ProductAdapter(list,this)
        binding.rvSnack.adapter = adapter
    }

    override fun onCellClickListener(data: ProductModel) {
        val intent = Intent(this@ListProductActivity, DetailProductActivity::class.java)
        intent.putExtra("data_produk",data)
        startActivity(intent)
    }
}