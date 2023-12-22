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
import com.aplhaacademy.alphalearn.databinding.FragmentChemistryBinding
import com.aplhaacademy.alphalearn.ui.course.CourseDetailActivity

class ChemistryFragment : Fragment() {

    private var _binding: FragmentChemistryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChemistryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val courseData = getDataForChemistry()

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

    private fun getDataForChemistry(): ArrayList<CourseTopic> {
        return ArrayList(CourseData.getChemistryData())
    }
}