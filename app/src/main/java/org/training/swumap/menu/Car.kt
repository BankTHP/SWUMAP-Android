package org.training.swumap.menu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import org.training.swumap.MainActivity
import org.training.swumap.R

class Car : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car)
        val swunow = findViewById<ImageView>(R.id.swunow)
        val oddhowto = findViewById<ImageView>(R.id.oddcarhowto)
        val oddbus = findViewById<ImageView>(R.id.oddbus)
        oddbus.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps?saddr=Current+Location&daddr=13.989345056226888,100.61793863355602"))
            startActivity(i)
        }
        oddhowto.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps?saddr=Current+Location&daddr=14.108082552608284, 100.9820422883539"))
            startActivity(i)
        }
        swunow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}