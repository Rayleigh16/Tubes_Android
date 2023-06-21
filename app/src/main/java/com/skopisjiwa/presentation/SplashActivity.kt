package com.skopisjiwa.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.skopisjiwa.MainActivity
import com.skopisjiwa.R
import com.skopisjiwa.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private val SPLASH_SCREEN_DURATION = 2000L // 2 seconds
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN_DURATION)
    }
}