package com.aplhaacademy.alphalearn.data.model

import android.os.Parcelable
import com.aplhaacademy.alphalearn.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class CourseTopic(var title: String, var name: String, var photo: Int): Parcelable