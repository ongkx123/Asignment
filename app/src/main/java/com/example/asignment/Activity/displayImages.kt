package com.example.asignment.Activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.asignment.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mancj.materialsearchbar.MaterialSearchBar
import kotlinx.android.synthetic.main.activity_display_images.*

class displayImages : AppCompatActivity() {
    private val db = FirebaseDatabase.getInstance()
    private val profile = db.getReference("article")
    private var list : MutableList<String> = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_images)
        displayImage()

        val lv = findViewById(R.id.mListView) as ListView
        val searchBar = findViewById(R.id.searchBar) as MaterialSearchBar

        //Retrieve values from firebase
        profile.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                //Get firebase values
                for(i: DataSnapshot in dataSnapshot.children.iterator()){
                    list.add(i.child("title").value.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@displayImages,"Error", Toast.LENGTH_SHORT).show()
            }
        })

        searchBar.setHint("Search..")
        searchBar.setSpeechMode(true)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        lv.setAdapter(adapter)

        searchBar.addTextChangeListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.getFilter().filter(charSequence)
            }

        })

        lv.setOnItemClickListener(object: AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                val sharedPreference: SharedPreferences = getSharedPreferences("Article",0)
                var editor = sharedPreference.edit()
                val intent = Intent(applicationContext, Articles::class.java)

                if(list.get(position).equals("What is Accounting?")){
                    editor.putString("Article","accounting")
                    editor.commit()

                    startActivity(intent)
                }else if(list.get(position).equals("What is Agriculture?")){
                    editor.putString("Article","agriculture")
                    editor.commit()

                    startActivity(intent)
                }else if(list.get(position).equals("What is Business?")){
                    editor.putString("Article","business")
                    editor.commit()

                    startActivity(intent)
                }else if(list.get(position).equals("What is Software Engineering?")){
                    editor.putString("Article","software")
                    editor.commit()

                    startActivity(intent)
                }else if(list.get(position).equals("What does a doctor do?")){
                    editor.putString("Article","medical")
                    editor.commit()

                    startActivity(intent)
                }else if(list.get(position).equals("What is a mechanic?")){
                    editor.putString("Article","mechanic")
                    editor.commit()

                    startActivity(intent)
                }
            }
        })
    }

    fun displayImage() {
        val sharedPreference:SharedPreferences = getSharedPreferences("Article",0)
        var editor = sharedPreference.edit()
        val url: String =
                "https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/image%2Faccounting.jpg?alt=media&token=d329da4b-c8bb-48fb-88fc-74f7490fed79"
        Glide.with(applicationContext).load(url).into(imageView)

        val url2: String =
                "https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/image%2Fagriculture.jpg?alt=media&token=d32513f8-04d8-4f67-9005-95ef16599bc6"
        Glide.with(applicationContext).load(url2).into(imageView2)

        val url3: String =
                "https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/image%2Fbusiness.jpg?alt=media&token=22aeb663-24a8-4103-87f7-bae6e45ae847"
        Glide.with(applicationContext).load(url3).into(imageView3)

        val url4: String =
                "https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/image%2Fdoctor.jpg?alt=media&token=41d35e04-aff4-43b3-9220-cb9818430d49"
        Glide.with(applicationContext).load(url4).into(imageView4)

        val url5: String =
                "https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/image%2Fmechanic.png?alt=media&token=6a883543-5268-4254-94fb-df5cc4a23f5e"
        Glide.with(applicationContext).load(url5).into(imageView5)

        val url6: String =
                "https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/image%2Fsoftware.jpg?alt=media&token=4e228a52-7aee-44af-8e56-1034b0ab7b36"
        Glide.with(applicationContext).load(url6).into(imageView6)

            imageView.setOnClickListener{
                editor.putString("Article","accounting")
                editor.apply()
                editor.commit()
                val intent = Intent(applicationContext,Articles::class.java)
                startActivity(intent)
            }
            imageView2.setOnClickListener{
                editor.putString("Article","agriculture")
                editor.apply()
                editor.commit()
                val intent = Intent(applicationContext,Articles::class.java)
                startActivity(intent)
            }
            imageView3.setOnClickListener{
                editor.putString("Article","business")
                editor.apply()
                editor.commit()
                val intent = Intent(applicationContext,Articles::class.java)
                startActivity(intent)
            }
            imageView4.setOnClickListener{
                editor.putString("Article","medical")
                editor.apply()
                editor.commit()
                val intent = Intent(applicationContext,Articles::class.java)
                startActivity(intent)
            }
            imageView5.setOnClickListener{
                editor.putString("Article","mechanic")
                editor.apply()
                editor.commit()
                val intent = Intent(applicationContext,Articles::class.java)
                startActivity(intent)
            }
            imageView6.setOnClickListener{
                editor.putString("Article","software")
                editor.apply()
                editor.commit()
                val intent = Intent(applicationContext,Articles::class.java)
                startActivity(intent)
            }

        }
    }
