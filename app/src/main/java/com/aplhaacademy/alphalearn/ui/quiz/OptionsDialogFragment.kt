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

    private var score: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentOptionsDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        score = arguments?.getInt(QuizResultActivity.EXTRA_SCORE) ?: 0

        binding.btnAkhiri.setOnClickListener {
            val intent = Intent(requireActivity(), QuizResultActivity::class.java).apply {
                putExtra(QuizResultActivity.EXTRA_SCORE, score)
            }

            startActivity(intent)
            activity?.finish()
        }

        binding.btnBatal.setOnClickListener {
            dismiss()
        }
    }
}