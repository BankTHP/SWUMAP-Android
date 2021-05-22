package org.training.swumap.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import org.training.swumap.MainActivity
import org.training.swumap.R

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val bts = findViewById<CardView>(R.id.bts)
        val mrt = findViewById<CardView>(R.id.mrt)
        val car = findViewById<CardView>(R.id.car)
        val boat = findViewById<CardView>(R.id.boat)
        val map = findViewById<CardView>(R.id.map)
        val arl = findViewById<CardView>(R.id.arl)
        val bus = findViewById<CardView>(R.id.bus)
        val quit = findViewById<CardView>(R.id.quit)

        bts.setOnClickListener{
            val intent = Intent(this, BTS::class.java)
            startActivity(intent)
        }
        map.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        bus.setOnClickListener{
            val intent = Intent(this, BUS::class.java)
            startActivity(intent)
        }
        arl.setOnClickListener{
            val intent = Intent(this, Airport::class.java)
            startActivity(intent)
        }
        car.setOnClickListener{
            val intent = Intent(this, gotoSWU::class.java)
            startActivity(intent)
        }
        boat.setOnClickListener{
            val intent = Intent(this, Boat::class.java)
            startActivity(intent)
        }
        mrt.setOnClickListener{
            val intent = Intent(this, MRT::class.java)
            startActivity(intent)
        }
        quit.setOnClickListener{
            this.finishAffinity();
        }
    }
}
