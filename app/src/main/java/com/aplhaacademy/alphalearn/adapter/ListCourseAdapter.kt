package com.aplhaacademy.alphalearn.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.data.model.CourseTopic
import com.aplhaacademy.alphalearn.ui.course.CourseDetailActivity

class ListCourseAdapter(private val listCourse: ArrayList<CourseTopic>) : RecyclerView.Adapter<ListCourseAdapter.ListViewHolder>()
{
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback)
    {
        this.onItemClickCallback = onItemClickCallback
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_course)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return ListViewHolder(view)
    }
    override fun getItemCount(): Int = listCourse.size
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, name, photo) = listCourse[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvTitle.text = title
        holder.tvName.text = name
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listCourse[position])
        }
    }
    interface OnItemClickCallback
    {
        fun onItemClicked(data: CourseTopic)
    }
}