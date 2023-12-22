package com.aplhaacademy.alphalearn.ui.course

import android.util.Log
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService

class PlaybackService : MediaSessionService() {

    private var mediaSession: MediaSession?=null

    override fun onCreate() {
        super.onCreate()
        initializeSessionAndPlayer()
    }

    private fun initializeSessionAndPlayer() {

        val videoItem = MediaItem.Builder()
            .setUri("https://dl.dropboxusercontent.com/scl/fi/w02pgnogdbfoo9s9bykyj/LOGO-MOTION.mp4?rlkey=dzeflfh8e9ifyfnjhmji4idr4&dl=0")
            .setMediaMetadata(
                MediaMetadata.Builder()
                    .setTitle("Definisi cuaca dan iklim")
                    .setArtist("Alpha Learn")
                    .build()
            ).build()

        val player = ExoPlayer.Builder(this).build().also { exoPlayer ->
            exoPlayer.setMediaItem(videoItem)
            exoPlayer.prepare()
            exoPlayer.addListener(object : Player.Listener {
                override fun onPlayerError(error: PlaybackException) {
                    // Tangani kesalahan pemutaran di sini
                    Log.d("Testttttttttttt", "Playback error", error)
                }
            })
        }

        mediaSession = MediaSession.Builder(this, player).build()
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaSession? {
        return mediaSession
    }

    override fun onDestroy() {
        mediaSession?.run {
            player.release()
            release()
            mediaSession = null
        }
        super.onDestroy()
    }
}