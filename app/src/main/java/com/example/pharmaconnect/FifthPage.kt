package com.example.pharmaconnect

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmaconnect.databinding.ActivityFifthPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FifthPage : AppCompatActivity() {

    private lateinit var binding: ActivityFifthPageBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        // Bouton retour
        binding.arrowpage5.setOnClickListener {
            finish()
        }

        // Bouton S'inscrire
        binding.btnFifthpSignup.setOnClickListener {
            val nomComplet = binding.nameInputFieldPage5.text.toString().trim()
            val email = binding.etFifthpEmail.text.toString().trim()
            val nomPharmacie = binding.etFifthpNamepharmacie.text.toString().trim()
            val password = binding.etFifthpPassword.text.toString().trim()

            // Validations
            if (nomComplet.isEmpty()) {
                binding.nameInputFieldPage5.error = "Entrez votre nom"
                return@setOnClickListener
            }
            if (email.isEmpty()) {
                binding.etFifthpEmail.error = "Entrez votre email"
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etFifthpEmail.error = "Email invalide"
                return@setOnClickListener
            }
            if (nomPharmacie.isEmpty()) {
                binding.etFifthpNamepharmacie.error = "Entrez le nom de la pharmacie"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.etFifthpPassword.error = "Entrez votre mot de passe"
                return@setOnClickListener
            }
            if (password.length < 6) {
                binding.etFifthpPassword.error = "Minimum 6 caractères"
                return@setOnClickListener
            }

            // Inscription Firebase Auth
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener { result ->
                    val uid = result.user?.uid ?: return@addOnSuccessListener

                    // Sauvegarder dans Firestore
                    val pharmacie = hashMapOf(
                        "nomComplet" to nomComplet,
                        "email" to email,
                        "nomPharmacie" to nomPharmacie,
                        "type" to "pharmacie"
                    )

                    db.collection("pharmacies").document(uid)
                        .set(pharmacie)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Compte créé avec succès !", Toast.LENGTH_SHORT).show()
                            // Aller à la page principale pharmacie
                            val intent = Intent(this, SixPage::class.java)
                            startActivity(intent)
                            finish()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Erreur : ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Erreur : ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }
}