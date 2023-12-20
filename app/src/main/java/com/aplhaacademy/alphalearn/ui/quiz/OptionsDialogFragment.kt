package com.aplhaacademy.alphalearn.ui.quiz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.aplhaacademy.alphalearn.databinding.FragmentOptionsDialogBinding
import com.aplhaacademy.alphalearn.ui.quizresult.QuizResultActivity

class OptionsDialogFragment : DialogFragment() {

    private var _binding: FragmentOptionsDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentOptionsDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAkhiri.setOnClickListener {
            val intent = Intent(requireActivity(), QuizResultActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        binding.btnBatal.setOnClickListener {
            dismiss()
        }
    }
}