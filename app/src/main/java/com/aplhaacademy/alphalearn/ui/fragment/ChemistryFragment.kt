package com.aplhaacademy.alphalearn.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.adapter.ListCourseAdapter
import com.aplhaacademy.alphalearn.data.model.CourseTopic
import com.aplhaacademy.alphalearn.databinding.FragmentChemistryBinding

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

        val courseList = ArrayList<CourseTopic>()
        val dataNames = resources.getStringArray(R.array.data_name)
        val dataTypes = resources.getStringArray(R.array.data_type)
        val dataPhotos = resources.obtainTypedArray(R.array.data_photo)

        for (i in dataNames.indices) {
            courseList.add(CourseTopic(dataNames[i], dataTypes[i], dataPhotos.getResourceId(i, -1)))
        }

        dataPhotos.recycle()

        val listCourseAdapter = ListCourseAdapter(courseList)
        binding.rvCourse.layoutManager = LinearLayoutManager(activity)
        binding.rvCourse.adapter = listCourseAdapter

        listCourseAdapter.setOnItemClickCallback(object : ListCourseAdapter.OnItemClickCallback {
            override fun onItemClicked(data: CourseTopic) {

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}