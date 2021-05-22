package org.training.swumap.menu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.training.swumap.MainActivity
import org.training.swumap.R


class Airport : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_airport)
        val swunow = findViewById<Button>(R.id.swunow)
        val howto = findViewById<Button>(R.id.howtoair)


        howto.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps?saddr=13.751256486094643,%20100.56077100910281&daddr=13.748612591703694,%20100.56309778196888"))
            startActivity(i)
        }
        swunow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}