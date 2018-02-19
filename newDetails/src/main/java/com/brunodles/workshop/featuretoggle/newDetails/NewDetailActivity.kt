package com.brunodles.workshop.featuretoggle.newDetails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.brunodles.workshop.featuretoggle.R

class NewDetailActivity : AppCompatActivity() {

    lateinit var chosen: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_details)
        chosen = findViewById(R.id.chosen)
        chosen.text = intent.getIntExtra(EXTRA_POSITION, -1).toString()
    }

    companion object {

        const val EXTRA_POSITION = "EXTRA_POSITION"

        // sem newIntentAqui, já que essa activity só vai ser chamada pelo módulo app
    }
}
