package org.training.swumap.menu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import org.training.swumap.MainActivity
import org.training.swumap.R

class carpramit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carpramit)
        val swunow = findViewById<ImageView>(R.id.swunow)
        val oddhowto = findViewById<ImageView>(R.id.oddcarhowto)


        oddhowto.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps?saddr=13.735733624374685,%20100.5625898148299&daddr=13.74401819082544,%20100.56397155942464"))
            startActivity(i)
        }
        swunow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}