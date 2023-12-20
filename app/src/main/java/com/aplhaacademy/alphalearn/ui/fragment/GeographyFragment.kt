package com.aplhaacademy.alphalearn.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aplhaacademy.alphalearn.adapter.ListCourseAdapter
import com.aplhaacademy.alphalearn.data.dummy.CourseData
import com.aplhaacademy.alphalearn.data.model.CourseTopic
import com.aplhaacademy.alphalearn.databinding.FragmentGeographyBinding
import com.aplhaacademy.alphalearn.ui.course.CourseDetailActivity

class GeographyFragment : Fragment() {

    private var _binding: FragmentGeographyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentGeographyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val courseData = getDataForGeography()

        binding.rvCourse.layoutManager = LinearLayoutManager(activity)
        binding.rvCourse.adapter = ListCourseAdapter(courseData).apply {
            setOnItemClickCallback(object : ListCourseAdapter.OnItemClickCallback{
                override fun onItemClicked(data: CourseTopic) {
                    val intent = Intent(requireContext(), CourseDetailActivity::class.java)
                    intent.putExtra(CourseDetailActivity.EXTRA_COURSE_TITLE, data.title)
                    startActivity(intent)
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getDataForGeography(): ArrayList<CourseTopic> {
        return ArrayList(CourseData.getGeographyData())
    }
}