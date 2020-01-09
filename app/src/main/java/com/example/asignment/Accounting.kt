package com.example.asignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_accounting.*

class Accounting : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounting)

        webView.loadUrl("https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/accounting.mp4?alt=media&token=7449690c-8f97-47ad-9654-2c974738d9fe")
    }
}
