package org.training.swumap

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.training.swumap.adapter.MyAdapter
import org.training.swumap.model.SWUS
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

        private lateinit var swuRecyclerView: RecyclerView
        private lateinit var  swuArrayList: ArrayList<SWUS>
        private lateinit var tempArrayList : ArrayList<SWUS>

        lateinit var imageId : Array<Int>
        lateinit var heading : Array<String>
        lateinit var campus : Array<String>
        lateinit var  lat : Array<Double>
        lateinit var  lon : Array<Double>
        lateinit var  website : Array<String>


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            imageId = arrayOf(
                R.drawable.human,
                R.drawable.science,
                R.drawable.social,
                R.drawable.pe,
                R.drawable.education,
                R.drawable.nursing,
                R.drawable.medicine,
                R.drawable.engineering,
                R.drawable.fineart,
                R.drawable.dentistry,
                R.drawable.pharmacy,
                R.drawable.therapy,
                R.drawable.econnomics,
                R.drawable.cosci,
                R.drawable.bodhivijjalaya,
                R.drawable.ic,
                R.drawable.ai,
                R.drawable.ece,
                R.drawable.graduate,
                R.drawable.cci,
                R.drawable.business,
                R.drawable.human,
                R.drawable.bodhivijjalaya,
                R.drawable.pe,
                R.drawable.medicine
            )

            heading = arrayOf(
                "มนุษยศาสตร์(ตึกใหม่)",
                "วิทยาศาสตร์",
                "สังคมศาสตร์",
                "พลศึกษา",
                "ศึกษาศาสตร์",
                "พยาบาลศาสตร์",
                "แพทยศาสตร์",
                "วิศวกรรมศาสตร์",
                "ศิลปกรรมศาสตร์",
                "ทันตแพทยศาสตร์",
                "เภสัชศาสตร์",
                "กายภาพบำบัด",
                "เศรษฐศาสตร์",
                "วิทยาลัยนวัตกรรมสื่อสารสังคม",
                "วิทยาลัยโพธิวิชชาลัย",
                "วิทยาลัยนานาชาติเพื่อศึกษาความยั่งยืน",
                "เทคโนโลยีและนวัตกรรมผลิตภัณฑ์การเกษตร",
                "วัฒนธรรมสิ่งแวดล้อมและการท่องเที่ยวเชิงนิเวศ",
                "บัณฑิตวิทยาลัย",
                "วิทยาลัยอุตสาหกรรมสร้างสรรค์",
                "บริหารธุรกิจเพื่อสังคม",
                "มนุษยศาสตร์",
                "วิทยาลัยโพธิวิชชาลัย(สระแก้ว)",
                "พลศึกษา",
                "แพทยศาสตร์"
            )

            campus = arrayOf(
                "ประสานมิตร",
                "ประสานมิตร",
                "ประสานมิตร",
                "ประสานมิตร",
                "ประสานมิตร",
                "องครักษ์",
                "องครักษ์",
                "องครักษ์",
                "ประสานมิตร",
                "ประสานมิตร",
                "องครักษ์",
                "องครักษ์",
                "ประสานมิตร",
                "ประสานมิตร",
                "ประสานมิตร",
                "ประสานมิตร",
                "องครักษ์",
                "ประสานมิตร",
                "ประสานมิตร",
                "ประสานมิตร",
                "ประสานมิตร",
                "ประสานมิตร",
                "สระแก้ว",
                "องครักษ์",
                "ประสานมิตร"
            )
            lat = arrayOf(
                13.746878689630137,
                13.746787607860718,
                13.744552385054101,
                13.747063064013535,
                13.746166094044588,
                14.109373485138748,
                14.110869802120511,
                14.103138621078763,
                13.74581493876519,
                13.745466129292442,
                14.107665945313448,
                14.105623666476031,
                13.74459697893882,
                13.747251225822275,
                13.74486269635503,
                13.745045562577682,
                14.10540416958946,
                13.745109641606764,
                13.74397865890207,
                13.745208350119498,
                13.744729563653749,
                13.746578255413633,
                13.913945339573855,
                14.104500617617393,
                13.74686962108766
            )
            lon = arrayOf(
                100.56523995923506,
                100.56686609078616,
                100.56401818789118,
                100.5645239639841,
                100.5649476283461,
                100.9845238696448,
                100.98345136701863,
                100.98234291510133,
                100.56640546241631,
                100.56637472869845,
                100.98502101456054,
                100.9850483140773,
                100.56362523905054,
                100.56545723817673,
                100.56641117388553,
                100.56651725218146,
                100.98258635963354,
                100.56375942048892,
                100.56401463542747,
                100.5637597510277,
                100.56377845416192,
                100.56578394033502,
                102.3729545328716,
                100.9811563225764,
                100.56600375119146
            )
            website = arrayOf(
                "http://hu.swu.ac.th/",
                "http://science.swu.ac.th/",
                "https://soc.swu.ac.th/th/",
                "http://pe.swu.ac.th/",
                "http://edu.swu.ac.th/",
                "http://nurse.swu.ac.th/",
                "http://med.swu.ac.th/th/",
                "http://eng.swu.ac.th/",
                "http://fofa.swu.ac.th/",
                "http://dent.swu.ac.th/",
                "http://pharmacy.swu.ac.th/",
                "http://healthsci.swu.ac.th/",
                "https://econ.swu.ac.th/",
                "http://cosci.swu.ac.th/",
                "https://bodhi.swu.ac.th/",
                "http://ic.swu.ac.th/",
                "http://ai.swu.ac.th/",
                "http://ece.swu.ac.th/",
                "http://grad.swu.ac.th/TH/Home",
                "https://cci.swu.ac.th/",
                "https://bas.swu.ac.th/",
                "http://hu.swu.ac.th/",
                "https://bodhi.swu.ac.th/",
                "http://pe.swu.ac.th/",
                "http://med.swu.ac.th/th/"
            )
            swuRecyclerView = findViewById(R.id.recyclerView)
            swuRecyclerView.layoutManager = LinearLayoutManager(this)
            swuRecyclerView.setHasFixedSize(true)

            swuArrayList = arrayListOf<SWUS>()
            tempArrayList = arrayListOf<SWUS>()
            getUserData()

        }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {

            menuInflater.inflate(R.menu.menu_item,menu)
            val item = menu?.findItem(R.id.search_action)
            val searchView = item?.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    TODO("Not yet implemented")
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    tempArrayList.clear()
                    val searchText = newText!!.toLowerCase(Locale.getDefault())
                    if (searchText.isNotEmpty()){

                        swuArrayList.forEach {

                            if (it.heading.toLowerCase(Locale.getDefault()).contains(searchText) || it.campus.toLowerCase(
                                    Locale.getDefault()
                                ).contains(searchText)){


                                tempArrayList.add(it)

                            }

                        }

                        swuRecyclerView.adapter!!.notifyDataSetChanged()

                    }else{

                        tempArrayList.clear()
                        tempArrayList.addAll(swuArrayList)
                        swuRecyclerView.adapter!!.notifyDataSetChanged()

                    }


                    return false

                }


            })
            return super.onCreateOptionsMenu(menu)
        }


        private fun getUserData() {
            for(i in imageId.indices){
                val swus = SWUS(imageId[i], heading[i], campus[i], lat[i], lon[i], website[i])
                swuArrayList.add(swus)

            }
            tempArrayList.addAll(swuArrayList)

            var adapter = MyAdapter(tempArrayList)
            swuRecyclerView.adapter = adapter
            adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {
                    //Toast.makeText(this@MainActivity,swuArrayList[position].lon.toString(),Toast.LENGTH_LONG).show()
                    val intent = Intent(this@MainActivity, swuActivity::class.java)
                    intent.putExtra("heading",swuArrayList[position].heading)
                    intent.putExtra("imageId",swuArrayList[position].titleImage)
                    intent.putExtra("campus",swuArrayList[position].campus)
                    intent.putExtra("lat",swuArrayList[position].lat)
                    intent.putExtra("lon",swuArrayList[position].lon)
                    intent.putExtra("website",swuArrayList[position].website)
                    startActivity(intent)

                }

            })
        }

    }