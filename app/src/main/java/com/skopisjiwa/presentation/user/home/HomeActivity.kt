package com.skopisjiwa.presentation.user.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.marginTop
import androidx.navigation.navArgs
import com.skopisjiwa.MainActivity
import com.skopisjiwa.R
import com.skopisjiwa.databinding.ActivityHomeBinding
import com.skopisjiwa.databinding.ActivitySplashBinding
import com.skopisjiwa.presentation.user.store.StoreActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private var roleId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        roleId = intent.getLongExtra("roleId", 0)


//        admin
        if (roleId == 1L) {
            adminMenu()
        }
        if (roleId == 3L) {   //customer
            binding.apply {
                btnPickUp.setOnClickListener {
                    val intent = Intent(this@HomeActivity, StoreActivity::class.java)
                    startActivity(intent)
                }
            }
        } else {  // mitra
            binding.apply {

            }
        }

        binding.btnSignOut.setOnClickListener {
            val intent = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }


    private fun adminMenu() {
        binding.btnPickUp.text = "Outlet"
        val layoutParam = binding.btnPickUp.layoutParams as ViewGroup.MarginLayoutParams
        layoutParam.topMargin = convertDpToPx(100)
        binding.btnDriveThru.visibility = View.GONE


        // to list store
        binding.btnPickUp.setOnClickListener {
            val intent = Intent(this@HomeActivity, StoreActivity::class.java)
            intent.putExtra("roleId", roleId)
            startActivity(intent)
        }
    }

    private fun convertDpToPx(dp: Int): Int {
        val density = resources.displayMetrics.density
        return (dp * density).toInt()
    }
}