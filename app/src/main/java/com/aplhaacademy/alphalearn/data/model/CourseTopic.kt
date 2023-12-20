package com.aplhaacademy.alphalearn.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CourseTopic(var title: String, var name: String, var photo: Int): Parcelable