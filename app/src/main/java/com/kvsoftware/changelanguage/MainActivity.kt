package com.kvsoftware.changelanguage

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val LANGUAGE_EN = "en_US"
        const val LANGUAGE_TH = "th"
    }

    override fun attachBaseContext(newBase: Context) {
        val language = SharedPreferences(newBase).language ?: LANGUAGE_EN
        val localeUpdatedContext = CustomWrapper.updateLocale(newBase, Locale(language))
        super.attachBaseContext(localeUpdatedContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_english).setOnClickListener {
            SharedPreferences(this).language = LANGUAGE_EN
            openMainActivity()
        }
        findViewById<Button>(R.id.button_thai).setOnClickListener {
            SharedPreferences(this).language = LANGUAGE_TH
            openMainActivity()
        }
    }

    private fun openMainActivity() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }

}