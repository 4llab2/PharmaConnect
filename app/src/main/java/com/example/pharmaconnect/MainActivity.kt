package com.example.pharmaconnect

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmaconnect.databinding.FirstPageBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: FirstPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FirstPageBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnHomeLogin.setOnClickListener {
            val connect  = Intent(this, MainActivity2::class.java)
            startActivity(connect)

        }

        binding.btnHomeSignup.setOnClickListener {
            val new_person = Intent(this , MainActivity3::class.java)
            startActivity(new_person)
        }

    }
}