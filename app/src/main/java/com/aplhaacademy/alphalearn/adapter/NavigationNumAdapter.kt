package com.aplhaacademy.alphalearn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aplhaacademy.alphalearn.data.model.Question
import com.aplhaacademy.alphalearn.databinding.LayoutItemQuestionNumBinding

class NavigationNumAdapter: RecyclerView.Adapter<NavigationNumAdapter.ViewHolder>() {

    private var questionNums = ArrayList<Question>()

    fun setQuestionNUm(newQuestion: List<Question>) {
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
    }
}