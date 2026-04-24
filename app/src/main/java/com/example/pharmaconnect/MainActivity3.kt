package com.example.pharmaconnect

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmaconnect.databinding.ThirdPageBinding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ThirdPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThirdPageBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        binding.clientLayout.setOnClickListener {
            var client  = Intent ( this, FourthPage::class.java)
            startActivity(client)
        }
        binding.ivThirdpArrow.setOnClickListener {
            finish()
         }

        binding.pharmacieLayout.setOnClickListener {
            val pharmacie  = Intent ( this, FifthPage::class.java)
            startActivity(pharmacie)
        }


    }
}