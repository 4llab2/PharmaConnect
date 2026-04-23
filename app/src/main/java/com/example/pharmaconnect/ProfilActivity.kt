package com.example.pharmaconnect

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ProfilActivity : AppCompatActivity() {

    private fun openPage(activity: Class<*>) {
        val intent = Intent(this, activity)
        startActivity(intent)
        overridePendingTransition(
            R.anim.fade_in,
            R.anim.fade_out
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.pharmaconnect.R.layout.activity_profil)

        val btnAccueil = findViewById<Button>(com.example.pharmaconnect.R.id.btnAccueil)
        val btnCarte = findViewById<Button>(com.example.pharmaconnect.R.id.btnCarte)
        val btnCommande = findViewById<Button>(com.example.pharmaconnect.R.id.btnCommande)
        val btnProfil = findViewById<Button>(com.example.pharmaconnect.R.id.btnProfil)
        val btnLogout = findViewById<Button>(com.example.pharmaconnect.R.id.btnLogout)


        val greenColor = ContextCompat.getColor(this, com.example.pharmaconnect.R.color.green)
        btnProfil.setTextColor(greenColor)

        btnLogout.setOnClickListener {
            Toast.makeText(this, "Déconnexion...", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, AccueilActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        btnCarte.setOnClickListener {
            openPage(MapsActivity::class.java)
        }

        btnAccueil.setOnClickListener {
            openPage(AccueilActivity::class.java)
        }

        btnCommande.setOnClickListener {
            openPage(CommandeActivity::class.java)
        }

    }
}