package com.example.asignment

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_accounting.*


class Accounting : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounting)
        val sharedPreferences: SharedPreferences = getSharedPreferences("PREFERENCE_NAME",0)
        var editor = sharedPreferences.edit()

        var name: String? = sharedPreferences.getString("NAME","")

        Toast.makeText(this@Accounting,name,Toast.LENGTH_SHORT).show()
        webView.loadUrl("https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/accounting.mp4?alt=media&token=7449690c-8f97-47ad-9654-2c974738d9fe")
    }
}
