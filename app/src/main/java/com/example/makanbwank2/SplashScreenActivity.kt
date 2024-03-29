
package com.example.makanbwank2
// SplashScreenActivity.kt
import android.annotation.SuppressLint
import android.content.Intent

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        // Using Handler to delay the transition to the next activity
        Handler().postDelayed({
            // Start your main activity here
            val intent = Intent(this, HomeNavigationActivity::class.java)
            startActivity(intent)
            finish() // Close this activity
        }, SPLASH_TIME_OUT)
    }
}
