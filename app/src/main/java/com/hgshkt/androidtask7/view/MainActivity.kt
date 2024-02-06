package com.hgshkt.androidtask7.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hgshkt.androidtask7.R
import com.hgshkt.androidtask7.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textView: TextView

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        viewModel.numberLiveData.observe(this) {
            textView.text = it.toString()
        }

        button.setOnClickListener {
            viewModel.add()
        }
    }

    private fun init() {
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}