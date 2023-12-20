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
import com.aplhaacademy.alphalearn.databinding.FragmentPhysicsBinding
import com.aplhaacademy.alphalearn.ui.course.CourseDetailActivity
import com.aplhaacademy.alphalearn.ui.course.CourseDetailActivity.Companion.EXTRA_COURSE_TITLE

class PhysicsFragment : Fragment() {

    private var _binding: FragmentPhysicsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPhysicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val courseData = getDataForPhysics()

        binding.rvCourse.layoutManager = LinearLayoutManager(activity)
        binding.rvCourse.adapter = ListCourseAdapter(courseData).apply {
            setOnItemClickCallback(object : ListCourseAdapter.OnItemClickCallback{
                override fun onItemClicked(data: CourseTopic) {
                    val intent = Intent(requireContext(), CourseDetailActivity::class.java)
                    intent.putExtra(EXTRA_COURSE_TITLE, data.title)
                    startActivity(intent)
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getDataForPhysics(): ArrayList<CourseTopic> {
        return ArrayList(CourseData.getPhysicsData())
    }
}