package com.aplhaacademy.alphalearn.ui.tryoutwork

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.aplhaacademy.alphalearn.adapter.NavigationNumAdapter
import com.aplhaacademy.alphalearn.data.dummy.QuestionNumData
import com.aplhaacademy.alphalearn.data.model.Question
import com.aplhaacademy.alphalearn.databinding.ActivityTryOutWorkBinding
import com.aplhaacademy.alphalearn.databinding.LayoutDialogCancelBinding
import com.aplhaacademy.alphalearn.databinding.LayoutNavigationNumberBinding
import com.aplhaacademy.alphalearn.ui.tryoutresult.TryOutResultActivity

class TryOutWorkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTryOutWorkBinding
    private lateinit var navigationNumAdapter: NavigationNumAdapter

    private var listQuestion: ArrayList<Question> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTryOutWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        onAction()
    }

    private fun initData() {
        listQuestion.addAll(QuestionNumData.listData)

        navigationNumAdapter = NavigationNumAdapter()
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
        val bindingAlert = LayoutNavigationNumberBinding.inflate(LayoutInflater.from(this@TryOutWorkActivity))
        var alertDialog = AlertDialog
            .Builder(this@TryOutWorkActivity)
            .setView(bindingAlert.root)
            .setCancelable(false)
            .create()

        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        bindingAlert.rvNavigationNum.apply {
            layoutManager = GridLayoutManager(this@TryOutWorkActivity, 5)
            adapter = navigationNumAdapter
        }

        bindingAlert.btnClose.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()

    }

    private fun setDialogCancelLayout() {
        val bindingAlert = LayoutDialogCancelBinding.inflate(LayoutInflater.from(this@TryOutWorkActivity))
        var alertDialog = AlertDialog
            .Builder(this@TryOutWorkActivity)
            .setView(bindingAlert.root)
            .setCancelable(false)
            .create()

        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        bindingAlert.apply {
            btnDone.setOnClickListener {
                alertDialog.dismiss()
                startActivity(
                    Intent(this@TryOutWorkActivity, TryOutResultActivity::class.java)
                )
            }

            btnCancel.setOnClickListener {
                alertDialog.dismiss()
            }
        }
        alertDialog.show()
    }
}