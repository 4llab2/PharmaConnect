package com.example.pharmaconnect

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmaconnect.databinding.ActivitySixPageBinding

class SixPage : AppCompatActivity() {

    private lateinit var binding: ActivitySixPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixPageBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

    }
}