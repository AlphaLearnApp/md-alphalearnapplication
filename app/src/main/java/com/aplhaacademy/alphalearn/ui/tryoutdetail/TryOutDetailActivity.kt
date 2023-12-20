package com.aplhaacademy.alphalearn.ui.tryoutdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.adapter.TryoutAdapter
import com.aplhaacademy.alphalearn.data.dummy.TryOutData
import com.aplhaacademy.alphalearn.data.model.TryOut
import com.aplhaacademy.alphalearn.databinding.ActivityTryOutDetailBinding
import com.aplhaacademy.alphalearn.ui.tryoutwork.TryOutWorkActivity
import com.aplhaacademy.alphalearn.utils.Constant.COURSE

class TryOutDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTryOutDetailBinding
    var course: String = ""
    private lateinit var tryoutAdapter: TryoutAdapter

    private var listTryout: ArrayList<TryOut> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTryOutDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getInformationFromIntent()
        initData()
        setInformation()
        setRvTryout()
        onAction()
        onItemClick()
    }

    private fun onItemClick() {
        tryoutAdapter.onItemClick = { tryout ->
            startActivity(
                Intent(this, TryOutWorkActivity::class.java)
            )
        }
    }

    private fun setRvTryout() {
        binding.rvTryout.apply {
            layoutManager = LinearLayoutManager(this@TryOutDetailActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = tryoutAdapter
        }
    }

    private fun initData() {
        listTryout.addAll(TryOutData.listData)

        tryoutAdapter = TryoutAdapter()
        tryoutAdapter.setTryout(listTryout)
    }

    private fun onAction() {

        binding.apply {
            ibBack.setOnClickListener {
                finish()
            }
        }

    }

    private fun setInformation() {
        binding.apply {
            tvCourseTitle.text = course
        }
    }

    private fun getInformationFromIntent() {
        course = intent.getStringExtra(COURSE).toString()
    }
}