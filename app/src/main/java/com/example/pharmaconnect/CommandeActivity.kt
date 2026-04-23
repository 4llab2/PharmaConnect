package com.example.pharmaconnect

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlin.jvm.java

class CommandeActivity : AppCompatActivity() {
    private fun openPage(activity: Class<*>) {
        val intent = Intent(this, activity)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.pharmaconnect.R.layout.activity_commande)

        val btnAccueil = findViewById<Button>(com.example.pharmaconnect.R.id.btnAccueil)
        val btnCarte = findViewById<Button>(com.example.pharmaconnect.R.id.btnCarte)
        var btnCommande = findViewById<Button>(com.example.pharmaconnect.R.id.btnCommande)
        val btnProfil = findViewById<Button>(com.example.pharmaconnect.R.id.btnProfil)

        btnCommande = findViewById<Button>(com.example.pharmaconnect.R.id.btnCommande)
        val greenColor = ContextCompat.getColor(this, com.example.pharmaconnect.R.color.green)
        btnCommande.setTextColor(greenColor)

        btnCarte.setOnClickListener {
            openPage(MapsActivity::class.java)
        }

        btnAccueil.setOnClickListener {
            openPage(AccueilActivity::class.java)
        }

        btnProfil.setOnClickListener {
            openPage(ProfilActivity::class.java)
        }
    }
}