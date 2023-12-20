package com.aplhaacademy.alphalearn.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.data.model.Topic
import com.aplhaacademy.alphalearn.ui.course.CourseArticleActivity
import com.aplhaacademy.alphalearn.ui.course.CourseVideoActivity
import com.aplhaacademy.alphalearn.ui.quiz.QuizDetailActivity

class ListTopicAdapter(private val list: List<Topic>) : RecyclerView.Adapter<ListTopicAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_topic, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val topic = list[position]

        holder.bind(topic)

        holder.itemView.setOnClickListener {
            val expanded = topic.expanded
            topic.expanded = !expanded
            notifyItemChanged(position)
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.findViewById(R.id.item_title)
        private val subtopic: TextView = itemView.findViewById(R.id.sub_topic)
        private val subItem: View = itemView.findViewById(R.id.sub_item)
        private val subtopic2: TextView = itemView.findViewById(R.id.sub_topic2)
        private val subItem2: View = itemView.findViewById(R.id.sub_item2)
        private val subtopic3: TextView = itemView.findViewById(R.id.sub_topic3)
        private val subItem3: View = itemView.findViewById(R.id.sub_item3)
        private val subtopic4: TextView = itemView.findViewById(R.id.sub_topic4)
        private val subItem4: View = itemView.findViewById(R.id.sub_item4)
        private val expandIcon: ImageView = itemView.findViewById(R.id.expand_icon)

        init {
            subItem.setOnClickListener {
                    itemView.context.startActivity(Intent(itemView.context, CourseVideoActivity::class.java))
            }
            subItem2.setOnClickListener {
                    itemView.context.startActivity(Intent(itemView.context, CourseVideoActivity::class.java))
            }
            subItem3.setOnClickListener {
                    itemView.context.startActivity(Intent(itemView.context, CourseArticleActivity::class.java))
            }
            subItem4.setOnClickListener {
                    itemView.context.startActivity(Intent(itemView.context, QuizDetailActivity::class.java))
            }
        }

        fun bind(topic: Topic) {
            val expanded = topic.expanded

            subItem.visibility = if (expanded) View.VISIBLE else View.GONE
            subItem2.visibility = if (expanded) View.VISIBLE else View.GONE
            subItem3.visibility = if (expanded) View.VISIBLE else View.GONE
            subItem4.visibility = if (expanded) View.VISIBLE else View.GONE

            title.text = topic.title
            subtopic.text = topic.subtopic
            subtopic2.text = topic.subtopic
            subtopic3.text = topic.subtopic
            subtopic4.text = topic.subtopic

            val iconResource = if (expanded) R.drawable.baseline_expand_circle_up_24 else R.drawable.baseline_expand_circle_down_24
            expandIcon.setImageDrawable(ContextCompat.getDrawable(itemView.context, iconResource))
        }
    }
}
