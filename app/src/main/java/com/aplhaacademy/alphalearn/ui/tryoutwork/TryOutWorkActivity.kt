package com.aplhaacademy.alphalearn.ui.tryoutwork

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
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
import com.aplhaacademy.alphalearn.data.model.QuestionNum
import com.aplhaacademy.alphalearn.databinding.ActivityTryOutWorkBinding
import com.aplhaacademy.alphalearn.databinding.LayoutDialogCancelBinding
import com.aplhaacademy.alphalearn.databinding.LayoutNavigationNumberBinding
import com.aplhaacademy.alphalearn.ui.quizresult.QuizResultActivity
import com.aplhaacademy.alphalearn.ui.tryoutresult.TryOutResultActivity
import java.util.concurrent.TimeUnit

class TryOutWorkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTryOutWorkBinding
    private lateinit var navigationNumAdapter: NavigationNumAdapter

    private var listQuestion: ArrayList<QuestionNum> = arrayListOf()

    private var currentQuestionIndex = 0
    private val selectedAnswers = mutableMapOf<Int, String>()

    private var countdownTimer: CountDownTimer? = null
    private val totalTimeInMillis: Long = 600000

    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTryOutWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        onAction()

        displayQuestion()

        binding.btnNext.setOnClickListener {
            navigateToNextQuestion()
        }

        binding.btnPrev.setOnClickListener {
            navigateToPreviousQuestion()
        }
    }

    private fun initData() {
        QuestionNumData.totalQestion = QuestionData.question.size
        listQuestion.addAll(QuestionNumData.listData)

        navigationNumAdapter = NavigationNumAdapter(this)
        navigationNumAdapter.setQuestionNUm(listQuestion)
    }

    private fun onAction() {
        binding.apply {

            btnFinish.setOnClickListener {
                setDialogCancelLayout()
            }

            val answerButtons = listOf(
                binding.rbOptionA,
                binding.rbOptionB,
                binding.rbOptionC,
                binding.rbOptionD
            )

            answerButtons.forEachIndexed { index, button ->
                button.setOnClickListener {
                    onAnswerButtonClick(button, index)
                }
            }

            btnNavigation.setOnClickListener {
                setNavigationLayout()
            }

            countdownTimer = object : CountDownTimer(totalTimeInMillis, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val formattedTime = String.format(
                        "%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % TimeUnit.HOURS.toMinutes(
                            1
                        ),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % TimeUnit.MINUTES.toSeconds(
                            1
                        )
                    )

                    binding.tvTime.text = formattedTime
                }

                override fun onFinish() {
                    Toast.makeText(this@TryOutWorkActivity, "Waktu habis", Toast.LENGTH_SHORT)
                        .show()
                    finishQuiz()
                    val correctAnswer = calculateCorrectAnswer()
                    val intent =
                        Intent(this@TryOutWorkActivity, TryOutResultActivity::class.java).apply {
                            putExtra(QuizResultActivity.EXTRA_SCORE, correctAnswer)
                        }
                    startActivity(intent)
                }
            }.start()
        }
    }

    private fun finishQuiz() {
        countdownTimer?.cancel()

        val correctAnswer = calculateCorrectAnswer()
        Log.d("QuizWorkingActivity", "correct answer: $correctAnswer")
    }

    private fun calculateCorrectAnswer(): Int {
        var correctCount = 0
        for ((index, question) in QuestionData.question.withIndex()) {
            val selectedAnswer = selectedAnswers[index]
            if (selectedAnswer == question.answer) {
                correctCount++
                Log.d("QuizWorkingActivity", "Question $index answered correctly")
            } else {
                Log.d(
                    "QuizWorkingActivity",
                    "Question $index answered incorrectly. Correct answer: ${question.answer}, Selected answer: $selectedAnswer"
                )
            }
        }
        Log.d("QuizWorkingActivity", "Total Correct Answers: $correctCount")

        score = correctCount * 3
        return score
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

        val currentQuestion = QuestionData.question[currentQuestionIndex]
        binding.tvTextQuestion.text = currentQuestion.question

        val questionNumber = currentQuestionIndex + 1
        binding.tvNumber.text = "Question no. $questionNumber"

        val answerButtons = listOf(
            binding.rbOptionA,
            binding.rbOptionB,
            binding.rbOptionC,
            binding.rbOptionD
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
            LayoutNavigationNumberBinding.inflate(LayoutInflater.from(this@TryOutWorkActivity))
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

        navigationNumAdapter.onItemClick = { position ->
            currentQuestionIndex = position
            displayQuestion()
            alertDialog.dismiss()
        }

        bindingAlert.btnClose.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    private fun onAnswerButtonClick(button: Button, index: Int) {
        resetButtonBackground()
        // menambahkan kondisi jika dia sudah terjawab
        navigationNumAdapter.questionNums[currentQuestionIndex].isSolve = true
        button.setBackgroundResource(R.drawable.bg_button_choose)
        selectedAnswers[currentQuestionIndex] =
            QuestionData.question[currentQuestionIndex].options[index]
        Log.d(
            "QuizWorkingActivity",
            "Selected Answer for Question $currentQuestionIndex: ${selectedAnswers[currentQuestionIndex]}"
        )
        calculateCorrectAnswer()
    }

    private fun resetButtonBackground() {
        val answerButtons = listOf(
            binding.rbOptionA,
            binding.rbOptionB,
            binding.rbOptionC,
            binding.rbOptionD
        )

        answerButtons.forEach {
            it.setBackgroundResource(R.drawable.bg_button_answer)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        countdownTimer?.cancel()
    }

    private fun setDialogCancelLayout() {
        val bindingAlert =
            LayoutDialogCancelBinding.inflate(LayoutInflater.from(this@TryOutWorkActivity))
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
                    Intent(this@TryOutWorkActivity, TryOutResultActivity::class.java).apply {
                        putExtra(TryOutResultActivity.EXTRA_SCORE, score)
                    }
                )
                btnCancel.setOnClickListener {
                    alertDialog.dismiss()
                }
            }
            alertDialog.show()
        }
    }
}