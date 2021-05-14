package com.rizkykurniawan.jetpackpro.submission1.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rizkykurniawan.jetpackpro.submission1.R
import com.rizkykurniawan.jetpackpro.submission1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityHomeViewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeViewBinding.root)
        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        activityHomeViewBinding.viewPager.adapter = sectionPagerAdapter
        activityHomeViewBinding.tabs.setupWithViewPager(activityHomeViewBinding.viewPager)
        supportActionBar?.elevation = 0f
    }
}