package org.training.swumap.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import org.training.swumap.R

class gotoSWU : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goto_swu)
        val paramit = findViewById<CardView>(R.id.pasramit)
        val odd = findViewById<CardView>(R.id.odd)

        odd.setOnClickListener{
            val intent = Intent(this, Car::class.java)
            startActivity(intent)
        }
        paramit.setOnClickListener{
            val intent = Intent(this, carpramit::class.java)
            startActivity(intent)
        }
    }
}