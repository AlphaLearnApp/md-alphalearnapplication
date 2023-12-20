package com.aplhaacademy.alphalearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.data.model.TitleCourse
import com.aplhaacademy.alphalearn.databinding.LayoutItemTitleCourseBinding

class TitleCourseAdapter(private val context: Context): RecyclerView.Adapter<TitleCourseAdapter.ViewHolder>() {

    lateinit var onItemClick: ((Int) -> Unit)

    class ViewHolder(var binding: LayoutItemTitleCourseBinding): RecyclerView.ViewHolder(binding.root)

    private var titleCourses = ArrayList<TitleCourse>()

    fun setTitleCourse(newTitleCourse: List<TitleCourse>) {
        titleCourses.clear()
        titleCourses.addAll(newTitleCourse)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutItemTitleCourseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TitleCourseAdapter.ViewHolder, position: Int) {
        var titleCourse = titleCourses[position]

        holder.binding.apply {
            if (titleCourse.status) {
                bgTitleCourse.setBackgroundResource(R.drawable.bg_rounded_mustard)
                tvTitleCourse.setTextColor(context.resources.getColor(R.color.colorWhite))
            } else {
                bgTitleCourse.setBackgroundResource(R.drawable.bg_rounded_soft_mustard)
                tvTitleCourse.setTextColor(context.resources.getColor(R.color.colorBlack))
            }

            tvTitleCourse.text = titleCourse.title
        }

        holder.itemView.setOnClickListener {
            onItemClick.invoke(position)
        }
    }

    override fun getItemCount(): Int = titleCourses.size
}