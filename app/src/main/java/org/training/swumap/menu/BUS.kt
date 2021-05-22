package org.training.swumap.menu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.training.swumap.MainActivity
import org.training.swumap.R

class BUS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus)
        val swunow = findViewById<Button>(R.id.swunow)
        val qho = findViewById<Button>(R.id.QHOUSE)
        val cp = findViewById<Button>(R.id.CP)


        cp.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps?saddr=13.745432014069909,%20100.56271183541024&daddr=13.74495662721125,%20100.56351637650808"))
            startActivity(i)
        }
        qho.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps?saddr=13.748495675456079,%20100.56637765406155&daddr=13.74672052026677,%20100.56562800554744"))
            startActivity(i)
        }
        swunow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}