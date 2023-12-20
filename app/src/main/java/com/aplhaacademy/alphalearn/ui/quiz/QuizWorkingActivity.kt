package com.aplhaacademy.alphalearn.ui.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.adapter.NavigationNumAdapter
import com.aplhaacademy.alphalearn.data.dummy.QuestionData
import com.aplhaacademy.alphalearn.data.dummy.QuestionNumData
import com.aplhaacademy.alphalearn.data.model.Question
import com.aplhaacademy.alphalearn.databinding.ActivityQuizWorkingBinding
import com.aplhaacademy.alphalearn.databinding.LayoutNavigationNumberBinding
import com.aplhaacademy.alphalearn.ui.quizresult.QuizResultActivity
import java.util.concurrent.TimeUnit

class QuizWorkingActivity : AppCompatActivity() {

    private lateinit var navigationNumAdapter: NavigationNumAdapter
    private var listQuestion: ArrayList<Question> = arrayListOf()

    private lateinit var binding: ActivityQuizWorkingBinding

    private var currentQuestionIndex = 0
    private val selectedAnswers = mutableMapOf<Int, String>()

    private var countdownTimer: CountDownTimer? = null
    private val totalTimeInMillis: Long = 10000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizWorkingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayQuestion()

        binding.btnNext.setOnClickListener {
            navigateToNextQuestion()
        }

        binding.btnPrevious.setOnClickListener {
            navigateToPreviousQuestion()
        }

        listQuestion.addAll(QuestionNumData.listData)
        navigationNumAdapter = NavigationNumAdapter()
        navigationNumAdapter.setQuestionNUm(listQuestion)

        binding.ibNavigation.setOnClickListener {
            setNavigationLayout()
        }

        val answerButtons = listOf(
            binding.btnAnswer1,
            binding.btnAnswer2,
            binding.btnAnswer3,
            binding.btnAnswer4
        )

        answerButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                onAnswerButtonClick(button, index)
            }
        }

        binding.btnFinish.setOnClickListener {
            val optionsDialogFragment = OptionsDialogFragment()
            val fragmentManager = supportFragmentManager
            optionsDialogFragment.show(
                fragmentManager,
                OptionsDialogFragment::class.java.simpleName
            )
        }

        countdownTimer = object : CountDownTimer(totalTimeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val formattedTime = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % TimeUnit.HOURS.toMinutes(1),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % TimeUnit.MINUTES.toSeconds(1)
                )

                binding.tvTime.text = formattedTime
            }

            override fun onFinish() {
                Toast.makeText(this@QuizWorkingActivity, "Waktu habis", Toast.LENGTH_SHORT).show()
                finishQuiz()
            }
        }.start()
    }

    private fun finishQuiz(){
        countdownTimer?.cancel()
        val intent = Intent(this@QuizWorkingActivity, QuizResultActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToNextQuestion() {
        if (currentQuestionIndex < QuestionData.question.size - 1) {
            currentQuestionIndex++
            displayQuestion()
        } else {
            Toast.makeText(this, "Kuis selesai", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToPreviousQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--
            displayQuestion()
        } else {
            Toast.makeText(this, "Ini adalah pertanyaan pertama", Toast.LENGTH_SHORT).show()
        }
    }
    private fun displayQuestion() {
        resetButtonBackground()
        val currentQuestion = QuestionData.question[currentQuestionIndex]
        binding.tvQuestion.text = currentQuestion.question

        val questionNumber = currentQuestionIndex + 1
        binding.tvNumber.text = "Question no. $questionNumber"

        val answerButtons = listOf(
            binding.btnAnswer1,
            binding.btnAnswer2,
            binding.btnAnswer3,
            binding.btnAnswer4
        )

        answerButtons.forEachIndexed { index, button ->
            if (index < currentQuestion.options.size) {
                button.text = currentQuestion.options[index]
                button.visibility = View.VISIBLE

                val selectedAnswer = selectedAnswers[currentQuestionIndex]
                if (selectedAnswer != null && selectedAnswer == currentQuestion.options[index]) {
                    button.setBackgroundResource(R.drawable.bg_button_choose)
                } else {
                    button.setBackgroundResource(R.drawable.bg_button_answer)
                }
            } else {
                button.visibility = View.GONE
            }
        }
    }

    private fun setNavigationLayout() {
        val bindingAlert =
            LayoutNavigationNumberBinding.inflate(LayoutInflater.from(this@QuizWorkingActivity))
        var alertDialog = AlertDialog
            .Builder(this@QuizWorkingActivity)
            .setView(bindingAlert.root)
            .setCancelable(false)
            .create()

        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        bindingAlert.rvNavigationNum.apply {
            layoutManager = GridLayoutManager(this@QuizWorkingActivity, 5)
            adapter = navigationNumAdapter
        }

        bindingAlert.btnClose.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()

    }

    private fun onAnswerButtonClick(button: Button, index: Int) {
        resetButtonBackground()
        button.setBackgroundResource(R.drawable.bg_button_choose)
        selectedAnswers[currentQuestionIndex] = QuestionData.question[currentQuestionIndex].options[index]
    }

    private fun resetButtonBackground() {
        val answerButtons = listOf(
            binding.btnAnswer1,
            binding.btnAnswer2,
            binding.btnAnswer3,
            binding.btnAnswer4
        )

        answerButtons.forEach {
            it.setBackgroundResource(R.drawable.bg_button_answer)
        }
    }
}