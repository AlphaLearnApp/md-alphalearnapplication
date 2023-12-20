package com.aplhaacademy.alphalearn.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aplhaacademy.alphalearn.adapter.CourseAdapter
import com.aplhaacademy.alphalearn.adapter.TitleCourseAdapter
import com.aplhaacademy.alphalearn.data.dummy.CourseData
import com.aplhaacademy.alphalearn.data.dummy.TitleCourseData
import com.aplhaacademy.alphalearn.data.model.Course
import com.aplhaacademy.alphalearn.data.model.TitleCourse
import com.aplhaacademy.alphalearn.databinding.ActivityMainBinding
import com.aplhaacademy.alphalearn.ui.fragment.MainFragmentActivity
import com.aplhaacademy.alphalearn.ui.tryout.TryOutActivity
import com.aplhaacademy.alphalearn.ui.tryoutdetail.TryOutDetailActivity
import com.aplhaacademy.alphalearn.utils.Constant

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var titleCourseAdapter: TitleCourseAdapter
    private lateinit var courseAdapter: CourseAdapter

    private var listTitleCourse: ArrayList<TitleCourse> = arrayListOf()
    private var listCourse: ArrayList<Course> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        onAction()
        setRvTitleCourse()
        setRvCourse()
        onItemClick()
    }

    private fun initData() {
        listTitleCourse.addAll(TitleCourseData.listData)
        listCourse.addAll(CourseData.listData)

        titleCourseAdapter = TitleCourseAdapter(this)
        titleCourseAdapter.setTitleCourse(listTitleCourse)

        courseAdapter = CourseAdapter()
        courseAdapter.setCourses(listCourse)
    }

    private fun setRvTitleCourse() {
        binding.rvTitleCourse.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = titleCourseAdapter
        }
    }

    private fun setRvCourse() {
        binding.rvCourse.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = courseAdapter
        }
    }

    private fun onItemClick() {
        titleCourseAdapter.onItemClick = { position ->
            listTitleCourse.forEachIndexed { index, titleCourse ->
                listTitleCourse[index].status = false
            }
            listTitleCourse[position].status = true
            setRvTitleCourse()
        }
    }

    private fun onAction() {
        binding.apply {
            tvSeeAllTryOut.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, TryOutActivity::class.java)
                )
            }

            tvSeeAllCourse.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity,  MainFragmentActivity::class.java)
                )
            }

            cardAstronomics.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, TryOutDetailActivity::class.java)
                        .putExtra(Constant.COURSE, "Astronomics")
                )
            }

            cardGeography.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, TryOutDetailActivity::class.java)
                        .putExtra(Constant.COURSE, "Geography")
                )
            }

            cardBiology.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, TryOutDetailActivity::class.java)
                        .putExtra(Constant.COURSE, "Biology")
                )
            }

            cardChemistry.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, TryOutDetailActivity::class.java)
                        .putExtra(Constant.COURSE, "Chemistry")
                )
            }

            cardMathematics.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, TryOutDetailActivity::class.java)
                        .putExtra(Constant.COURSE, "Mathematics")
                )
            }
        }
    }
}