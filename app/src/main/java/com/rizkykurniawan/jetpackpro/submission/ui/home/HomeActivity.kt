package com.rizkykurniawan.jetpackpro.submission.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rizkykurniawan.jetpackpro.submission.databinding.ActivityHomeBinding

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