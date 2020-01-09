package com.example.asignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_search.*

class Search : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show()

        webview.loadUrl("https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/accounting.mp4?alt=media&token=bfa476be-edaa-4320-99cf-4346cf3d8334")
    }
}
