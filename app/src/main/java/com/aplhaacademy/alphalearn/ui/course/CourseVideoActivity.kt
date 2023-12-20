package com.aplhaacademy.alphalearn.ui.course

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.aplhaacademy.alphalearn.R
import com.aplhaacademy.alphalearn.adapter.ListTopicAdapter
import com.aplhaacademy.alphalearn.data.model.Topic
import com.aplhaacademy.alphalearn.databinding.ActivityCourseVideoBinding
import com.google.common.util.concurrent.MoreExecutors

class CourseVideoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCourseVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieList = listOf(
            Topic("Schindler's List", "Biography, Drama, History"),
            Topic("Pulp Fiction", "Crime, Drama"),
            Topic("No Country for Old Men", "Crime, Drama, Thriller"),
            Topic("Léon: The Professional", "Crime, Drama, Thriller"),
            Topic("Fight Club", "Drama"),
            Topic("Forrest Gump", "Drama, Romance"),
            Topic("The Shawshank Redemption", "Crime, Drama"),
            Topic("The Godfather", "Crime, Drama"),
            Topic("A Beautiful Mind", "Biography, Drama"),
            Topic("Good Will Hunting", "Drama")
        )

        val adapter = ListTopicAdapter(movieList)

        val recyclerView: RecyclerView = findViewById(R.id.rv_topic)

        (recyclerView.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        binding.backButton.setOnClickListener {
            val intent = Intent(this@CourseVideoActivity, CourseDetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        val sessionToken = SessionToken(this, ComponentName(this, PlaybackService::class.java))
        val controllerFuture = MediaController.Builder(this, sessionToken).buildAsync()
        controllerFuture.addListener(
            { binding.playerView.player = controllerFuture.get() },
            MoreExecutors.directExecutor()
        )
    }
}