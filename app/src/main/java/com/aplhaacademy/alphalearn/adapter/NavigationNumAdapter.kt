package com.aplhaacademy.alphalearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.data.model.QuestionNum
import com.aplhaacademy.alphalearn.databinding.LayoutItemQuestionNumBinding

class NavigationNumAdapter(private val context: Context): RecyclerView.Adapter<NavigationNumAdapter.ViewHolder>() {

    lateinit var onItemClick: ((Int) -> Unit)

    var questionNums = ArrayList<QuestionNum>()

    fun setQuestionNUm(newQuestion: List<QuestionNum>) {
        questionNums.clear()
        questionNums.addAll(newQuestion)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: LayoutItemQuestionNumBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutItemQuestionNumBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = questionNums.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var questionNum = questionNums[position]

        holder.binding.apply {
            tvNumber.text = questionNum.number.toString()
        }
        if (questionNum.isSolve == true) {
            holder.binding.bgNumItem.setBackgroundColor(context.resources.getColor(R.color.colorGreen))
        }

        holder.itemView.setOnClickListener {
            onItemClick.invoke(position)
        }
    }
}