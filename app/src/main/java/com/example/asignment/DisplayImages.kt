package com.example.asignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.internal.Storage
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File

class DisplayImages : AppCompatActivity() {
    lateinit var storage: FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_images)
        storage = FirebaseStorage.getInstance()

        displayImage()
    }

    private fun displayImage(){
        val url = storage.reference
    }
}
