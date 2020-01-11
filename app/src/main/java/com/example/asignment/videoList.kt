package com.example.asignment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class videoList : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_list)
        val context:Context
        var option:RequestOptions
       // Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/accounting.mp4?alt=media&token=7449690c-8f97-47ad-9654-2c974738d9fe").apply(option)

        //val list = findViewById<ListView>(R.id.video_list_view)

        //list.adapter = MyCustomAdapter(this)
    }

    /*private class MyCustomAdapter(context: Context): BaseAdapter() {
        private val mContext : Context
        private val db = FirebaseDatabase.getInstance()
        private val profile = db.getReference("image")

        init{
            mContext = context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val textView = TextView(mContext)
            //return textView
            profile.addValueEventListener(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {
                    //Toast.makeText(context,"Error", Toast.LENGTH_SHORT).show()
                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val list: ArrayList<String> = ArrayList()
                    for(i:DataSnapshot in dataSnapshot.children.iterator()){
                        val value:String = (list.add(i.child("image").value.toString()).toString())

                    }

                    textView.text = list.get(0)
                }

            })
            return textView

        }

        override fun getItem(position: Int): Any {
            return "Test String"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return 7
        }

    }*/

   /* override fun  display(){
        profile.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(this@videoList,"Error", Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val list: ArrayList<String> = ArrayList()
                for(i:DataSnapshot in dataSnapshot.children.iterator()){
                    list.add(i.child("image").value.toString())

                }
            }

        })
    }*/

}
