package com.aplhaacademy.alphalearn.ui.quizrecommendation

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.aplhaacademy.alphalearn.adapter.NavigationNumAdapter
import com.aplhaacademy.alphalearn.data.dummy.QuestionNumData
import com.aplhaacademy.alphalearn.data.model.QuestionNum
import com.aplhaacademy.alphalearn.databinding.ActivityQuizRecomBinding
import com.aplhaacademy.alphalearn.databinding.LayoutDialogCancelBinding
import com.aplhaacademy.alphalearn.databinding.LayoutNavigationNumberBinding
import com.aplhaacademy.alphalearn.ui.main.MainActivity

class QuizRecomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizRecomBinding
    private lateinit var navigationNumAdapter: NavigationNumAdapter

    private var listQuestion: ArrayList<QuestionNum> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizRecomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        onAction()

    }

    private fun initData() {
        listQuestion.addAll(QuestionNumData.listData)

        navigationNumAdapter = NavigationNumAdapter(this)
        navigationNumAdapter.setQuestionNUm(listQuestion)
    }

    private fun onAction() {
        binding.apply {
            btnFinish.setOnClickListener {
                setDialogCancelLayout()
            }

            btnNavigation.setOnClickListener {
                setNavigationLayout()
            }
        }
    }

    private fun setNavigationLayout() {
        val bindingAlert = LayoutNavigationNumberBinding.inflate(LayoutInflater.from(this@QuizRecomActivity))
        var alertDialog = AlertDialog
            .Builder(this@QuizRecomActivity)
            .setView(bindingAlert.root)
            .setCancelable(false)
            .create()

        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        bindingAlert.rvNavigationNum.apply {
            layoutManager = GridLayoutManager(this@QuizRecomActivity, 5)
            adapter = navigationNumAdapter
        }

        bindingAlert.btnClose.setOnClickListener {
            alertDialog.dismiss()
        }
        alertDialog.show()

    }

    private fun setDialogCancelLayout() {
        val bindingAlert = LayoutDialogCancelBinding.inflate(LayoutInflater.from(this@QuizRecomActivity))
        var alertDialog = AlertDialog
            .Builder(this@QuizRecomActivity)
            .setView(bindingAlert.root)
            .setCancelable(false)
            .create()

        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        bindingAlert.apply {
            btnDone.setOnClickListener {
                alertDialog.dismiss()
                startActivity(
                    Intent(this@QuizRecomActivity, MainActivity::class.java)
                )
                finishAffinity()
            }

            btnCancel.setOnClickListener {
                alertDialog.dismiss()
            }
        }
        alertDialog.show()
    }

}
