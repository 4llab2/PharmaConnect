package com.example.pharmaconnect

// Imports Firebase nécessaires
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmaconnect.databinding.SecondPageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity2 : AppCompatActivity() {
    

    private lateinit var binding: SecondPageBinding
    // Déclaration de l'instance FirebaseAuth au niveau de la classe
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Initialisation du Binding
        binding = SecondPageBinding.inflate(layoutInflater)

        // 2. Initialisation de Firebase Auth
        auth = Firebase.auth

        enableEdgeToEdge()
        setContentView(binding.root)

        // Gestion du bouton retour
        binding.ivSecondpageArrow.setOnClickListener {
            finish()
        }

        // 3. Logique du bouton de connexion
        binding.btnSecondpLogin.setOnClickListener {
            val email = binding.etSecondpEmail.text.toString().trim()
            val password = binding.etSecondpPassword.text.toString().trim()

            // Vérifications des champs (Validation)

            if (email.isEmpty()) {
                binding.etSecondpEmail.error = "Entrez votre email"
            }
            else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etSecondpEmail.error = "Email invalide"
            }
            else if (password.isEmpty()) {
                binding.etSecondpPassword.error = "Entrez votre mot de passe"
            }
            else if (password.length < 6) {
                binding.etSecondpPassword.error = "Minimum 6 caractères"
            }
            else {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener {
                        val intent =Intent(this, accueil_client::class.java)
                        startActivity(intent)
                        finish()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Erreur d'authentification", Toast.LENGTH_SHORT).show()
                    }

            }
        }

        // Mot de passe oublié
        binding.tvSecondpPassOublier.setOnClickListener {
           val page6 = Intent(this, SixPage::class.java)
            startActivity(page6)
        }
        binding.tvSecondpSignup.setOnClickListener {
            val page4 = Intent(this, FourthPage::class.java)
            startActivity(page4)
        }
    }
}