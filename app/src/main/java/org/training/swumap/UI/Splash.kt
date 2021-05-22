package org.training.swumap.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import org.training.swumap.R
import org.training.swumap.menu.Menu

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val backgroundImg : ImageView = findViewById(R.id.logo)
        val sideanim = AnimationUtils.loadAnimation(this, R.anim.slide)
        backgroundImg.startAnimation(sideanim)

        Handler().postDelayed({
            startActivity(Intent(this, Welcome::class.java))
            finish()
        },3000)

    }
}