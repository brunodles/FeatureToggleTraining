package com.brunodles.workshop.featuretoggle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private lateinit var chosen: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        chosen = findViewById(R.id.chosen)
        chosen.text = intent.getIntExtra(EXTRA_POSITION, -1).toString()
    }

    companion object {

        const val EXTRA_POSITION = "EXTRA_POSITION"
        private const val ACTION_NEW_DETAILS = "com.brunodles.workshop.featuretoggle.ACTION_NEW_DETAILS"

        fun newIntent(context: Context, position: Int): Intent {
            if (false) { // featureToggle: FLAG_USE_NEW_DETAILS
                val intent = Intent(ACTION_NEW_DETAILS)
                        .addCategory(context.packageName)
                        .putExtra(EXTRA_POSITION, position)
                if (intent.resolveActivity(context.packageManager) != null)
                    return intent
            }
            return Intent(context, DetailActivity::class.java)
                    .putExtra(EXTRA_POSITION, position)
        }
    }
}