package com.aplhaacademy.alphalearn.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.aplhaacademy.alphalearn.R

class ButtonCustom : AppCompatButton {

    private lateinit var enableBackground: Drawable
    private lateinit var disableBackground: Drawable
    private var txtColor: Int = 8

    constructor(context: Context) : super(context){
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        background = if (isEnabled) enableBackground else disableBackground

        setTextColor(txtColor)
        gravity = Gravity.CENTER
    }

    private fun init(){
        txtColor = ContextCompat.getColor(context, android.R.color.white)
        enableBackground = ContextCompat.getDrawable(context, R.drawable.bg_button_custom_primary) as Drawable
        disableBackground = ContextCompat.getDrawable(context, R.drawable.bg_button_disabled) as Drawable
    }
}