package org.training.swumap.UI

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import org.training.swumap.R
import org.training.swumap.adapter.OnBoardingViewPagerAdapter
import org.training.swumap.menu.Menu
import org.training.swumap.model.OnBoardingData

class Welcome : AppCompatActivity() {
    var OnBoardingViewPagerAdapter : OnBoardingViewPagerAdapter? = null
    var tablayout : TabLayout? = null
    var onBoardingViewPager : ViewPager? = null
    var nextbtn : TextView? = null
    var position = 0
    var sharedPreferences : SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(restorePrefdata()){
            val i = Intent(applicationContext,Menu::class.java)
            startActivity(i)
            finish()
        }

        setContentView(R.layout.activity_welcome)
        tablayout = findViewById(R.id.tab_indicator)
        nextbtn = findViewById(R.id.nextBtn)

        val onBoardingData:MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(OnBoardingData(" WELCOME TO SWUMAP","ยินดีต้อนรับสู่ SWUMAP",R.drawable.cat))
        onBoardingData.add(OnBoardingData("แนะนำแอพ","แอพที่นำพาคุณไปยังจุดหมาย!",R.drawable.cat2))
        onBoardingData.add(OnBoardingData("หน้าสอนใช้","จะมีปุ่มนำทางและเว็บไซต์เพื่ออำนวยความสะดวกแก่คุณ!",R.drawable.cat3))


        setOnBoardingViewPagerAdapter(onBoardingData)

        position = onBoardingViewPager!!.currentItem
        nextbtn?.setOnClickListener{
            if(position < onBoardingData.size){
                position++
                onBoardingViewPager!!.currentItem = position

            }
            if (position == onBoardingData.size){
                savePrefdata()
                val i = Intent(applicationContext,Menu::class.java)
                startActivity(i)
            }
            tablayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    position = tab!!.position
                    if(tab.position == onBoardingData.size - 1){
                        nextbtn!!.text = "SWUMAP"
                    }else{
                        nextbtn!!.text = "NEXT"
                    }
                }
                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }
            })

        }
    }
    private fun setOnBoardingViewPagerAdapter(onBoardingData: List<OnBoardingData>){

        onBoardingViewPager  = findViewById(R.id.Pagersview)
        OnBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(this,onBoardingData)
        onBoardingViewPager!!.adapter = OnBoardingViewPagerAdapter
        tablayout?.setupWithViewPager(onBoardingViewPager)
    }
    private fun savePrefdata() {
        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor  = sharedPreferences!!.edit()
        editor.putBoolean("FirstTimeRun",true)
        editor.apply()
    }
    private fun restorePrefdata() : Boolean{
        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("FirstTimeRun",false)
    }
}