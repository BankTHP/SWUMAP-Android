package org.training.swumap


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

private const val PERMISSION_REQUEST = 10
class swuActivity : AppCompatActivity(), OnMapReadyCallback {
   private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swu)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapswu) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        val headingNews: TextView = findViewById(R.id.heading)
        val imageswus: ImageView = findViewById(R.id.image_heading)
        val campusswus: TextView = findViewById(R.id.campustxt)
        val btngps: ImageButton = findViewById(R.id.btnGPS)
        val webbtn: ImageButton = findViewById(R.id.websiteBtn)



        val bundle: Bundle? = intent.extras
        val heading = bundle!!.getString("heading")
        val imageId = bundle.getInt("imageId")
        val campus = bundle!!.getString("campus")
        val latvalues = bundle.getDouble("lat")
        val lonvalues = bundle.getDouble("lon")
        val website = bundle!!.getString("website")

        headingNews.text = heading
        campusswus.text = campus
        imageswus.setImageResource(imageId)

        webbtn.setOnClickListener({
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("$website"))
            startActivity(i)
        })
        btngps.setOnClickListener({
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.co.th/maps?t=m&f=d&saddr=Current+Location&daddr=$latvalues,$lonvalues"))
                startActivity(i)
            })

    }

    override fun onMapReady(googlemap : GoogleMap?) {
        val bundle: Bundle? = intent.extras
        val latvalues = bundle?.getDouble("lat")
        val lonvalues = bundle?.getDouble("lon")
        val heading = bundle!!.getString("heading")
        var swupostiton = LatLng(latvalues!!.toDouble(),lonvalues!!.toDouble())
        googlemap?.addMarker(
            MarkerOptions()
                .position(swupostiton)
                .title(heading.toString())
        )
        googlemap?.moveCamera(CameraUpdateFactory.newLatLng(swupostiton))
        googlemap?.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
