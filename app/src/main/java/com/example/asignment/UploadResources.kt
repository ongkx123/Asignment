package com.example.asignment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.google.firebase.storage.UploadTask.TaskSnapshot
import kotlinx.android.synthetic.main.activity_image.*
import kotlinx.android.synthetic.main.activity_upload_resources.*

class UploadResources : AppCompatActivity() {

    val PDF : Int = 0
    val DOCX : Int = 1
    val AUDIO : Int = 2
    val VIDEO : Int = 3
    lateinit var uri : Uri
    lateinit var storageReference: StorageReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_resources)

        storageReference = FirebaseStorage.getInstance().getReference("image/")

        val pdfBtn = findViewById<View>(R.id.pdfBtn) as Button
        val docxBtn = findViewById<View>(R.id.docxBtn) as Button
        val musicBtn = findViewById<View>(R.id.musicBtn) as Button
        val videoBtn = findViewById<View>(R.id.videoBtn) as Button

        pdfBtn.setOnClickListener(View.OnClickListener {
            view:   View? -> val intent = Intent()
            intent.setType("pdf/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select PDF"), PDF)
        })
        docxBtn.setOnClickListener(View.OnClickListener {
                view:   View? -> val intent = Intent()
            intent.setType ("docx/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select DOCX"), DOCX)
        })
        musicBtn.setOnClickListener(View.OnClickListener {
                view:   View? -> val intent = Intent()
            intent.setType ("audio/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select Audio"), AUDIO)
        })
        videoBtn.setOnClickListener(View.OnClickListener {
                view:   View? -> val intent = Intent()
            intent.setType ("video/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select Video"), VIDEO)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val uriTxt = findViewById<View>(R.id.uriTxt) as TextView
        if (resultCode == RESULT_OK) {
            if (requestCode == PDF) {
                uri = data!!.data!!
                uriTxt.text = uri.toString()
                upload ()
            }else if (requestCode == DOCX) {
                uri = data!!.data!!
                uriTxt.text = uri.toString()
                upload ()
            }else if (requestCode == AUDIO) {
                uri = data!!.data!!
                uriTxt.text = uri.toString()
                upload ()
            }else if (requestCode == VIDEO) {
                uri = data!!.data!!
                uriTxt.text = uri.toString()
                upload ()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun upload(){
        var mReference = storageReference.child(uri.lastPathSegment!!)
        try {
            mReference.putFile(uri).addOnSuccessListener {
                    taskSnapshot: TaskSnapshot? ->
                val dwnTxt = findViewById<View>(R.id.dwnTxt) as TextView
                //dwnTxt.text = url.toString()
                Toast.makeText(this, "Successfully Uploaded :)", Toast.LENGTH_LONG).show()
            }
        }catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
