package com.example.pharmaconnect

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmaconnect.databinding.ActivityEighthPageBinding

class EighthPage : AppCompatActivity() {

    private lateinit var binding: ActivityEighthPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEighthPageBinding.inflate(layoutInflater)
        enableEdgeToEdge()

        setContentView(binding.root)

    }
}