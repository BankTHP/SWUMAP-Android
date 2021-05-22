package org.training.swumap.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import org.training.swumap.R
import org.training.swumap.model.SWUS

class MyAdapter(private val swusList : ArrayList<SWUS>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener) {

        mListener = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = swusList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.facultyheading.text = currentItem.heading
        holder.campustext.text = currentItem.campus
    }

    override fun getItemCount(): Int {
        return swusList.size
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        val titleImage: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val facultyheading: TextView = itemView.findViewById(R.id.Heading)
        val campustext : TextView = itemView.findViewById(R.id.campus)

        init {

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)

            }
        }
    }
}


