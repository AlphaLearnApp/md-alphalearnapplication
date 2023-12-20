package com.aplhaacademy.alphalearn.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aplhaacademy.alphalearn.data.model.Course
import com.aplhaacademy.alphalearn.data.model.TitleCourse
import com.aplhaacademy.alphalearn.databinding.LayoutItemCourseBinding
import com.aplhaacademy.alphalearn.ui.course.CourseDetailActivity
import com.bumptech.glide.Glide

class CourseAdapter: RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    private var courses = ArrayList<Course>()

    fun setCourses(newCourses: List<Course>) {
        courses.clear()
        courses.addAll(newCourses)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: LayoutItemCourseBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutItemCourseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = courses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var course = courses[position]

        Glide.with(holder.itemView)
            .load(course.imageUrl)
            .into(holder.binding.ivCourse)

        holder.binding.apply {
            tvCourse.text = course.course
            tvTitleCourse.text = course.titleCourse
            tvRateCourse.text = course.rating.toString()
            tvAuthor.text = "By ${course.author}"
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CourseDetailActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }
}