package com.example.fundus_overlay

import android.annotation.SuppressLint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Drawable.layer-list test"
        imageView = findViewById(R.id.imageView)

        //only show eye image
        change_opacity(R.id.overlay_ex, 0)
        change_opacity(R.id.overlay_he, 0)
        change_opacity(R.id.overlay_ma, 0)
        change_opacity(R.id.overlay_od, 0)
        //load layers of images
        imageView.setImageDrawable(resources.getDrawable(R.drawable.layers))
    }

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_ex -> {
                    if (checked) {
                        change_opacity(R.id.overlay_ex, 255)
                    } else {
                        change_opacity(R.id.overlay_ex, 0)
                    }
                }
                R.id.checkbox_he -> {
                    if (checked) {
                        change_opacity(R.id.overlay_he, 255)
                    } else {
                        change_opacity(R.id.overlay_he, 0)
                    }
                }
                R.id.checkbox_ma -> {
                    if (checked) {
                        change_opacity(R.id.overlay_ma, 255)
                    } else {
                        change_opacity(R.id.overlay_ma, 0)
                    }
                }
                R.id.checkbox_od -> {
                    if (checked) {
                        change_opacity(R.id.overlay_od, 255)
                    } else {
                        change_opacity(R.id.overlay_od, 0)
                    }
                }
            }
        }
    }

    fun change_opacity(id_of_drawable : Int, alpha : Int){
        var layerDrawable = resources.getDrawable(R.drawable.layers) as LayerDrawable
        var bitmapDrawable = layerDrawable.findDrawableByLayerId(id_of_drawable) as BitmapDrawable
        bitmapDrawable.alpha = alpha
        imageView.setImageDrawable(resources.getDrawable(R.drawable.layers))
    }
}