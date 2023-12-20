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

        val topicList = listOf(
            Topic("Pengantar Cuaca dan Iklim", "Definisi cuaca dan iklim", "Proses Pembentukan Atmosfer Bumi", "Komponen cuaca dan iklim", "Knowledge Check"),
            Topic("Sirkulasi Atmosfer", "Sirkulasi atmosfer pada taraf global", "Angin", "Sistem tiga sel", "Knowledge Check"),
            Topic("Siklus Hidrologi", "Jenis Siklus Hidrologi", "Penguapan", "Perawanan", "Knowledge Check"),
            Topic("Massa Udara", "Definisi dan ciri massa udara", "Pembentukan massa udara dan modifikasinya", "Jenis massa udara dan modifikasinya", "Knowledge Check"),
            Topic("Front", "Definisi front","Jenis front", "Dampak front", "Knowledge Check"),
            Topic("Klasifikasi Iklim", "Dasar klasifikasi iklim", "Jenis-jenis klasifikasi iklim", "Pembagian zona iklim dunia", "Knowledge Check"),
            Topic("Bencana dan Anomali Meteorologis", "Siklon tropis", "Tornado, water spout", "Thunderstorm", "Knowledge Check"),
            Topic("Pemanasan Global dan Perubahan Iklim", "Definisi dan perbedaan antara pemanasan global dan perubahan iklim", "Kontroversi pemanasan global dan perubahan iklim", "Penyebab dan akibat pemanasan global", "Knowledge Check"),
            Topic("Isu dan Kebijakan Terkait Iklim", "Konferensi Perubahan Iklim", "Protokol Montreal", "Rio Earth Summit", "Knowledge Check"),
            Topic("Observasi Meteorologi dan Penyajian Data", "Kontroversi pemanasan global dan perubahan iklim", "Penyebab dan akibat pemanasan global", "Sebab-akibat perubahan iklim", "Knowledge Check"),
        )

        val adapter = ListTopicAdapter(topicList)

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