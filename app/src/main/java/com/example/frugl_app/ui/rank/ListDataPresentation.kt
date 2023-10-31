package com.example.frugl_app.ui.rank

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.frugl_app.R

class ListDataPresentation : AppCompatActivity() {

    //@RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_data_presentation)

        val item: String = intent.getStringExtra("data") ?: "NADA"

        val textView: TextView = findViewById(R.id.textReciever)
        textView.text = item
    }
}