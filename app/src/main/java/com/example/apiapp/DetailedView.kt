package com.example.apiapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailedView : AppCompatActivity() {
    internal lateinit var imageView: ImageView
    internal lateinit var titleTextView: TextView
    internal lateinit var explanationTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        imageView = findViewById(R.id.imageView)


        titleTextView = findViewById(R.id.titleTextView)
        explanationTextView = findViewById(R.id.explanationTextView)


        Glide.with(applicationContext).load(intent.getStringExtra("ImageUrl")).into(this.imageView)
        titleTextView.text = intent.getStringExtra("Title")
        explanationTextView.text = intent.getStringExtra("Explanation")


    }
}
