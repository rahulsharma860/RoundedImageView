package com.rahul.designerratingbar

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.ImageView.ScaleType
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.rahul.roundimageview.R


public class RoundImageView : LinearLayout {

    lateinit var view: View

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }


    public fun init(localContext: Context, attrs: AttributeSet?) {
        view = inflate(localContext, R.layout.designer_layout, this)
        var cardBorder = view.findViewById<CardView>(R.id.cardBorder)
        var imageView = view.findViewById<AppCompatImageView>(R.id.img)

        val ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundImageView)
        var image = ta.getString(R.styleable.RoundImageView_image)
        var borderColor = ta.getColor(R.styleable.RoundImageView_border_color, Color.GREEN)
        var drawable = ta.getDrawable(R.styleable.RoundImageView_drawable)
        var scaleType = ta.getString(R.styleable.RoundImageView_scale_type)
//        var backgroundColor = ta.getDrawable(R.styleable.RoundImageView_background_color)

        if (drawable != null) {
            imageView.setImageDrawable(drawable)
        } else if (image != null) {
            Glide.with(this).load(image).into(imageView)
        }

        if (scaleType != null) {
            when (scaleType) {
                "center" -> {
                    imageView.scaleType=ImageView.ScaleType.CENTER
                }

                "center_crop" -> {
                    imageView.scaleType=ImageView.ScaleType.CENTER_CROP
                }

                "center_inside" -> {
                    imageView.scaleType=ImageView.ScaleType.CENTER_INSIDE
                }

                "fit_center" -> {
                    imageView.scaleType=ImageView.ScaleType.FIT_CENTER
                }

                "fit_end" -> {
                    imageView.scaleType=ImageView.ScaleType.FIT_END
                }

                "fit_start" -> {
                    imageView.scaleType=ImageView.ScaleType.FIT_START
                }

                "fit_xy" -> {
                    imageView.scaleType=ImageView.ScaleType.FIT_XY
                }

                "matrix" -> {
                    imageView.scaleType=ImageView.ScaleType.MATRIX
                }
                else ->{
                    imageView.scaleType=ImageView.ScaleType.CENTER_CROP
                }
            }
        }

        if (borderColor != null) {
            cardBorder.setCardBackgroundColor(borderColor)
        }
        ta.recycle()

    }


}