package com.example.linkedinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import coil.load

lateinit var tvDetail : TextView
lateinit var ivProfileTwo : ImageView

class DetailPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)

        tvDetail=findViewById(R.id.tvDetail)
        ivProfileTwo=findViewById(R.id.ivProfileTwo)

        val notification = intent.getParcelableExtra<Notification>("notification")
        notification?.let {
            tvDetail.text  = it.content
            ivProfileTwo.load(notification.profile)
        }
        
    }
}