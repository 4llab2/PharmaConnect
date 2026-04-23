package com.example.pharmaconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmaconnect.databinding.SecondPageBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: SecondPageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SecondPageBinding.inflate(layoutInflater)


        enableEdgeToEdge()
        setContentView(binding.root)
        binding.ivSecondpageArrow.setOnClickListener {
            finish()
        }

        binding.etSecondpEmail.text
        binding.etSecondpPassword.text

        binding.btnSecondpLogin.setOnClickListener {
            val email = binding.etSecondpEmail.text.toString().trim()
            val password = binding.etSecondpPassword.text.toString().trim()

            if(email.isEmpty()){
                binding.etSecondpEmail.error = "Entrez votre email"
            }
            else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.etSecondpEmail.error = "Email invalide"
            }
            else if(password.isEmpty()) {
                binding.etSecondpPassword.error = "Entrez votre mot de passe"
            }
            else if (password.length < 6){
                binding.etSecondpPassword.error = "Minimum 6 caracteres"
            }
            else {
                val valide = Intent ( this , SixPage::class.java)
                startActivity(valide)
            }
        }

        binding.tvSecondpPassOublier.setOnClickListener {
            val pass_oublier = Intent ( this , SixPage::class.java)
            startActivity(pass_oublier)
        }

    }
}