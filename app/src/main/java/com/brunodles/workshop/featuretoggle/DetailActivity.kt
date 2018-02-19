package com.brunodles.workshop.featuretoggle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    lateinit var chosen: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        chosen = findViewById(R.id.chosen)
        chosen.text = intent.getIntExtra(EXTRA_POSITION, -1).toString()
    }

    companion object {

        const val EXTRA_POSITION = "EXTRA_POSITION"

        fun newIntent(context: Context, position: Int) = Intent(context, DetailActivity::class.java)
                .putExtra(EXTRA_POSITION, position)
    }
}