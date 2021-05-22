package org.training.swumap.menu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.training.swumap.MainActivity
import org.training.swumap.R

class BTS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bts)
        val swunow = findViewById<Button>(R.id.swunow)
        val howto = findViewById<Button>(R.id.howto)


        howto.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/dir/13.7369211,100.5605971/13.7370651,100.5612397/@13.7369271,100.559839,18z"))
            startActivity(i)
        }
        swunow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}