package com.kvsoftware.changelanguage

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_english).setOnClickListener {
            changeLanguage("en_US")
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
        findViewById<Button>(R.id.button_thai).setOnClickListener {
            changeLanguage("th")
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun changeLanguage(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config: Configuration = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}