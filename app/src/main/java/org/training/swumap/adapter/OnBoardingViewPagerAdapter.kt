package org.training.swumap.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import org.training.swumap.R
import org.training.swumap.model.OnBoardingData

class OnBoardingViewPagerAdapter(private var context : Context, private var OnBoardingDataList : List<OnBoardingData>) : PagerAdapter() {
    override fun getCount(): Int {
        return OnBoardingDataList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.onboarding_screen_layout,null)
        val imageView : ImageView
        var title : TextView
        var desc : TextView

        imageView = view.findViewById(R.id.imageView)
        title = view.findViewById(R.id.titleView)
        desc = view.findViewById(R.id.desc)

        imageView.setImageResource(OnBoardingDataList[position].imagesUrl)
        title.text =  OnBoardingDataList[position].title
        desc.text = OnBoardingDataList[position].desc

        container.addView(view)
        return view
    }
}