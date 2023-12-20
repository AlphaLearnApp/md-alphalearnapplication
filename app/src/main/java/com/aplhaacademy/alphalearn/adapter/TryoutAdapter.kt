package com.aplhaacademy.alphalearn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aplhaacademy.alphalearn.data.model.TryOut
import com.aplhaacademy.alphalearn.databinding.LayoutItemTryoutBinding
import com.bumptech.glide.Glide

class TryoutAdapter: RecyclerView.Adapter<TryoutAdapter.ViewHolder>() {

    lateinit var onItemClick: ((TryOut) -> Unit)

    private var tryouts = ArrayList<TryOut>()

    fun setTryout(newTryout: List<TryOut>) {
        tryouts.clear()
        tryouts.addAll(newTryout)
        notifyDataSetChanged()
    }


    class ViewHolder(var binding: LayoutItemTryoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutItemTryoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = tryouts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var tryout = tryouts[position]

        Glide.with(holder.itemView)
            .load(tryout.imageUrl)
            .into(holder.binding.ivCourse)

        holder.binding.apply {
            tvCourseTryout.text = tryout.course
            tvTitleTryout.text = tryout.titleTryout
            tvTime.text = "${tryout.time} minutes"
            tvQuestionCount.text = "${tryout.questionTotal} soal"
        }

        holder.itemView.setOnClickListener {
            onItemClick.invoke(tryout)
        }
    }
}