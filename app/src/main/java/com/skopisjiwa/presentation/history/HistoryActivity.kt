package com.skopisjiwa.presentation.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skopisjiwa.R
import com.skopisjiwa.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}