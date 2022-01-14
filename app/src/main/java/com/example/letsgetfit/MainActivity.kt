package com.example.letsgetfit

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.letsgetfit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadJsonPicture()

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    private fun loadJsonPicture() {
        try {
            Glide.with(this).load(IMAGE_URL)
                .into(object : CustomTarget<Drawable>() {
                    override fun onResourceReady(dr: Drawable, tran: Transition<in Drawable?>?) {
                        binding.frameLayout.background = dr
                    }

                    override fun onLoadCleared(p0: Drawable?) {

                    }
                })
        } catch (e: Exception) {
        }
    }

    companion object {
        private const val IMAGE_URL = "http://95.217.132.144/russian_sport/background_image.jpg"
    }
}