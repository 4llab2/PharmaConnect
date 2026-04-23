package com.example.pharmaconnect

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmaconnect.databinding.ActivitySeventhPageBinding

class SeventhPage : AppCompatActivity() {

    private lateinit var binding: ActivitySeventhPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeventhPageBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

    }
}