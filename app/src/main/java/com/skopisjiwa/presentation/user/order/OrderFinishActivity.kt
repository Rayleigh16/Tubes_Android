package com.skopisjiwa.presentation.user.order

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skopisjiwa.databinding.ActivityOrderFinishBinding
import com.skopisjiwa.presentation.user.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderFinishActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOrderPage.setOnClickListener {
            val intent = Intent(this@OrderFinishActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}