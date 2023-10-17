package com

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.tp_1.R

class GalleryActivity : AppCompatActivity() {
    private lateinit var btnOpenGallery: Button
    private lateinit var imageView: ImageView

    companion object {
        const val PICK_IMAGE_REQUEST = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        btnOpenGallery = findViewById(R.id.btnOpenGallery)
        imageView = findViewById(R.id.imageView)

        btnOpenGallery.setOnClickListener {
            openGallery()
        }

    }
    private fun openGallery() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImage = data.data
            imageView.setImageURI(selectedImage)
            imageView.visibility = View.VISIBLE
        }
    }
}