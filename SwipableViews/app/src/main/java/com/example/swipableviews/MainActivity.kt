package com.example.swipableviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf(
            R.drawable.screenshot4,
            R.drawable.screenshot4,
            R.drawable.screenshot4,
            R.drawable.screenshot4,
            R.drawable.screenshot4
        )

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter

        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
    }
}