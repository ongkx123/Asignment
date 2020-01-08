package com.example.asignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.internal.Storage
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class Image : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        val storage = FirebaseStorage.getInstance()

        var storageRef = storage.reference
        var imagesRef: StorageReference? = storageRef.child("images")
        var spaceRef = storageRef.child("images/space.jpg")

        
    }
}
